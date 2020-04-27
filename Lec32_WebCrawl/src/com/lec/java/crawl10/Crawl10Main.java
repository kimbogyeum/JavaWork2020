package com.lec.java.crawl10;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* XML, Json 파싱1
 * 
 * ■서울시 지하철호선별 역별 승하차 인원 정보 ///ctrl누르고 누르면 바로 url로 넘어감
 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12914&srvType=A&serviceKind=1&currentPageNo=1
 * 
 * 샘플url
 * XML 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/xml/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/CardSubwayStatsNew/1/5/20181001
 *   
 * JSON 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/json/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/CardSubwayStatsNew/1/5/20181001 
 * */

/* JSON 파싱
java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
	├─ java.io.InputStreamReader    // 스트림 기반의 reader
 	└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */

public class Crawl10Main {

	public static final String REQ_SERVICE = "CardSubwayStatusNew";
	public static final String API_KEY = "4d69736a736b696d383449726d6f6f";

	public static void main(String[] args) {
		System.out.println("서울시 지하철호선별 역별 승하차 인원정보");

		int startIndex; // 요청시작위치 정수입력(페이징 시작번호입니다: 데이터 행 시작번호)
		int endIndex; // 요청 종료위치 정수입력(페이징 끝번호 입니다: 데이터 행 끝번호00)
		String date;

		String url_address;
		StringBuffer sb; // response 받은 텍스트

		startIndex = 1;
		endIndex = 5;
		date = "20200329";

		System.out.println("--------XML파싱---------");
		url_address = buildUrlAdress("xml", startIndex, endIndex, date);
		sb = readFromUrl(url_address);
		parseXML(sb.toString());

		System.out.println("--------JSON파싱---------");
		url_address=buildUrlAdress("json", startIndex, endIndex, date);
		sb = readFromUrl(url_address);
		parseJSON(sb.toString());

		System.out.println("\n프로그램 종료");

	}// end main

	public static String buildUrlAdress(String reqType, int startIndex, int endIndex, String date) {
		String url_adress = String.format("http://openapi.seoul.go.kr:8088/%s/%s/CardSubwayStatsNew/%d/%d/%s", 
				API_KEY, reqType, startIndex, endIndex, date);
		return url_adress;
	}

	/**
	 * @param urlAddress:주어진 url주소
	 * @return 서버로 부터 받은 텍스트 데이터(HTML)리턴
	 */
	public static StringBuffer readFromUrl(String urlAddress) {
		StringBuffer sb = new StringBuffer();// response 받은 데이터 담을 객체
		// StringBuffer에 차곡차곡 쌓아야해서 String대신 StringBuffer을 쓴거야..
		URL url = null; // java.net.URL

		HttpURLConnection conn = null;// java.net.HttpURLConnection
		InputStream in = null;// Stream이니까 byte형식
		InputStreamReader reader = null; // byte스트림--> 문자기반 Reader
		BufferedReader br = null;

		char[] buf = new char[512]; // 문자용 버퍼
		// BufferedReader <- InputStreamReader <- InputStream <- HttpURLConnection
		// 1.url객체
		try {
			url = new URL(urlAddress);
			try {
				conn = (HttpURLConnection) url.openConnection(); // Connection 객체 생성

				if (conn != null) {// url이랑 connect가 안되면 null이겠지
					conn.setConnectTimeout(2000); // 2초 이내에 '연결'이 수립이 안되면
													// java.net.SocketTimeoutException 발생
					conn.setRequestMethod("GET");// "GET","POST"....
					conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
					conn.setUseCaches(false);// 캐시사용 안함

					System.out.println("request 시작:" + urlAddress);
					conn.connect(); // request발생-> 이후 response받을때까지 delay
					System.out.println("response 완료");

					// response 받은 후 가장 먼저 response code값 확인
					int responseCode = conn.getResponseCode();
					System.out.println("response code:" + responseCode);// 무조건 200이 나와야 함.
					// 참조 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status
					if (responseCode == HttpURLConnection.HTTP_OK) {
						in = conn.getInputStream(); // InputStream <- HttpURLConnection
						reader = new InputStreamReader(in, "utf-8");
						br = new BufferedReader(reader); // BufferedReader <- InputStreamReader

						int cnt;
						while ((cnt = br.read(buf)) != -1) {// 글자 개수가 -1를 리턴하기 전까지 읽어야겠지
							sb.append(buf, 0, cnt);// response받은 텍스트를 StringBuffer에 추가
						}

					} else {
						System.out.println("response 실패");
						return null;

					}
				} else {// connection null
					System.out.println("conn null");
					return null;
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (conn != null)
				conn.disconnect();
		}

		return sb;
	}

	public static void parseXML(String xmlText) {
		// XML 파싱
		DocumentBuilderFactory dbFactory;
		DocumentBuilder dBuilder;

		try {
			// DOM parser 객체 생성
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();

			// String -> InputStream 변환
			InputStream in = new ByteArrayInputStream(xmlText.getBytes("utf-8"));

			// InputStream->Dom 객체 생성
			Document dom = dBuilder.parse(in);
			// DOM최상위 document element 추출
			Element docElement = dom.getDocumentElement();

			// 파싱하기 전 normalize()
			docElement.normalize();// 흩어진 text node들을 정렬하는 등의 절차, XML 파싱전에 꼭 normalize() 부터 해주자

			// DOM 내의 데이터 파싱
			NodeList nList = docElement.getElementsByTagName("row"); // <row>..</row> element들로 구성된 NodeList 리턴
			System.out.println("<row> 개수: " + nList.getLength());

			System.out.println();
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);

				// System.out.println("node Type: "+node.getNodeType());// element node 전부 1이
				// 나오지.
				// element node 인 경우만 파싱 진행
				if (node.getNodeType() != Node.ELEMENT_NODE)
					continue;
				Element rowElement = (Element) node; // node가 부모니까 형변환 해줘야지;
				String LINE_NUM = rowElement.getElementsByTagName("LINE_NUM").item(0).getChildNodes().item(0)
						.getNodeValue();
				String SUB_STA_NM = rowElement.getElementsByTagName("SUB_STA_NM").item(0).getChildNodes().item(0)
						.getNodeValue();
				String RIDE_PASGR_NUM = rowElement.getElementsByTagName("RIDE_PASGR_NUM").item(0).getChildNodes()
						.item(0).getNodeValue();
				String ALIGHT_PASGR_NUM = rowElement.getElementsByTagName("ALIGHT_PASGR_NUM").item(0).getChildNodes()
						.item(0).getNodeValue();
				// return값은 nodelist
				System.out.printf("%5s:%8s역[승차:%6s 하차:%6s]\n", LINE_NUM, SUB_STA_NM, RIDE_PASGR_NUM, ALIGHT_PASGR_NUM);

			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// end parseXML

	
	public static void parseJSON(String jsonText) {
		// org.json  라이브러리 다운로드
		// https://mvnrepository.com/artifact/org.json/json
		// 최신버젼 클릭후, Files 항목 클릭해서 다운로드

			JSONObject jObj=new JSONObject(jsonText);//JSON파싱: JSONObject <- String
			JSONArray row=jObj.getJSONObject("CardSubwayStatsNew").getJSONArray("row");
			//row가 Array니까 getJSONArray
			System.out.println("row의 개수: "+row.length());
			System.out.println();
		
			for (int i = 0; i < row.length(); i++) {
				JSONObject station=row.getJSONObject(i); 
				//row 에서 object에 담으면 i, 위에보면 row에 object를 담으면 CardSubwayStatsNew
				String LINE_NUM=station.getString("LINE_NUM");
				String SUB_STA_NM=station.getString("SUB_STA_NM");
				int RIDE_PASGR_NUM=station.getInt("RIDE_PASGR_NUM");
				int ALIGHT_PASGR_NUM=station.getInt("ALIGHT_PASGR_NUM");
				
				System.out.printf("%5s:%8s역[승차:%6s 하차:%6s]\n", LINE_NUM, SUB_STA_NM, RIDE_PASGR_NUM, ALIGHT_PASGR_NUM);
			}
		
		
		
		
		
		
		
	}//end parseJSON
}// end class
