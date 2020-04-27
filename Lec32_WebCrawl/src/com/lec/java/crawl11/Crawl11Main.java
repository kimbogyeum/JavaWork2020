package com.lec.java.crawl11;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

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
/*
 * XML ,JSON 파싱연습
--마지막에 /서울 인데 인코딩해서 넣어줘야해
--index지정  
 
START_INDEX	INTEGER(필수)	요청시작위치	정수 입력 (페이징 시작번호 입니다 : 데이터 행 시작번호)
END_INDEX	INTEGER(필수)	요청종료위치	정수 입력 (페이징 끝번호 입니다 : 데이터 행 끝번호)
statnNm	STRING(필수)	지하철역명	지하철역명

역이름(왕십리역이라고 넣으면 안되고 왕십리까지만), 번호, 호선이름 순으로 나와야해 

■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/서울




 */

public class Crawl11Main {

	public static final String REQ_SERVICE = "stationInfo";
	public static final String API_KEY = "4d69736a736b696d383449726d6f6f";

	public static void main(String[] args) {
		System.out.println("서울시 지하철 역사(station) 정보");

		String url_address="";
		StringBuffer sb; // response 받은 텍스트
		
		//TODO: API url에 필요한 parameter들
		int startIndex; //요청시작위치	정수 입력 (페이징 시작번호 입니다 : 데이터 행 시작번호)
		int endIndex; //정수 입력 (페이징 끝번호 입니다 : 데이터 행 끝번호)
		String statnNm; //지하철 역명
		
		startIndex=1;
		endIndex=5;
		statnNm="서울";
		
		
		System.out.println("--------XML파싱---------");
		try {
			statnNm= URLEncoder.encode(statnNm,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		url_address = buildUrlAdress("xml", startIndex, endIndex, statnNm);
		sb = readFromUrl(url_address);
//		System.out.println(url_address);
		parseXML(sb.toString());

		System.out.println("--------JSON파싱---------");
		//TODO
		url_address=buildUrlAdress("json", startIndex, endIndex, statnNm);
		sb = readFromUrl(url_address);
		parseJSON(sb.toString());

		System.out.println("\n프로그램 종료");

	}// end main

	
	public static String buildUrlAdress(String reqType, int startIndex, int endIndex, String statnNm) {
		String url_adress = String.format("http://swopenAPI.seoul.go.kr/api/subway/%s/%s/stationInfo/%d/%d/%s",
				API_KEY,reqType,startIndex,endIndex,statnNm);
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
		//XML 파싱
		DocumentBuilderFactory dbFactory;
		DocumentBuilder dBuilder;
		
		try {
			// DOM parser 객체 생성
			dbFactory=DocumentBuilderFactory.newInstance();
			dBuilder=dbFactory.newDocumentBuilder();
			
			// String -> InputStream 변환
			InputStream in=new ByteArrayInputStream(xmlText.getBytes("utf-8"));
			// InputStream->Dom 객체 생성
			Document dom=dBuilder.parse(in);
			// DOM최상위 document element 추출
			Element docElement=dom.getDocumentElement();
			// 파싱하기 전 normalize()
			docElement.normalize();
			// DOM 내의 데이터 파싱
			NodeList nList = docElement.getElementsByTagName("row"); // <row>..</row> element들로 구성된 NodeList 리턴
			System.out.println("<row> 개수: " + nList.getLength());
			
			System.out.println();
			for (int i = 0; i < nList.getLength(); i++) {
				Node node=nList.item(i);
				
				if(node.getNodeType()!=Node.ELEMENT_NODE)//node중에서 element타입인것만 찾도록 하겠다
					continue;
				Element rowElement=(Element)node;
				String statnNm=rowElement.getElementsByTagName("statnNm").item(0).getChildNodes().item(0).getNodeValue();//statnNm라는 element안에 새끼node가 서울을 갖고있다.
				String subwayId=rowElement.getElementsByTagName("subwayId").item(0).getChildNodes().item(0).getNodeValue();
				String subwayNm=rowElement.getElementsByTagName("subwayNm").item(0).getChildNodes().item(0).getNodeValue();
				
			    System.out.printf((i+1)+": %s역 %4s %s\n", statnNm, subwayId, subwayNm);
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end try 
		
	}// end parseXML

	
	public static void parseJSON(String jsonText) {
		JSONObject jObj=new JSONObject(jsonText); // JSON 파싱 --> JSONObject 로 변환
		JSONArray stationList=jObj.getJSONArray("stationList");
		
		System.out.println("Station 의 개수: "+stationList.length());
		System.out.println();
		
		for (int i = 0; i < stationList.length(); i++) {
			JSONObject station= stationList.getJSONObject(i);
			
			int rowNum=station.getInt("rowNum");
			String statnNm=station.getString("statnNm");
			String subwayId=station.getString("subwayId");
			String subwayNm=station.getString("subwayNm");
			
			System.out.println(rowNum + ": " + statnNm + "역 " + subwayId + " " + subwayNm);
			
		}
	}//end parseJSON
}// end class
