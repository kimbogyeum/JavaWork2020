package com.lec.java.crawl16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.5092242676215&lng=127.041292068684&order=rank&page=0&search=
public class Crawl16Main {

	public static void main(String[] args) throws IOException {
		System.out.println("요기요 맛집정보: header 추가 ");
		
		String url="https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.5092242676215&lng=127.041292068684&order=rank&page=0&search=\r\n";
		StringBuffer sb=readFromUrl(url);
//		System.out.println(sb); //200이 나와야 하는데 400이 나옴, 그러면 밑에 "헤더 정보 추가" 해주면 맛집 정보 다나옴
		
		
		ObjectMapper mapper=new ObjectMapper();
		Food food=mapper.readValue(sb.toString(),Food.class);
		//맛집이름, 평점
		for(FoodRow e: food.getRestaurants()) {
			System.out.printf("%s : %.1f \n",e.getName(),e.getReview_avg());
		}
		
		
		System.out.println("\n프로그램 종료");

	}//end main
	
	
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
					
					
					//헤더 정보 추가
					conn.setRequestProperty("X-ApiKey", "iphoneap");
					conn.setRequestProperty("x-apisecret", "fe5183cc3dea12bd0ce299cf110a75a2");

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


}//end class
@JsonIgnoreProperties(ignoreUnknown = true)//Pagination제외하기 
class Food {
	private List<FoodRow> restaurants;
	
	public List<FoodRow> getRestaurants() {
				return restaurants;
	}
	
	public void setRestaurants(List<FoodRow> restaurants) {
				this.restaurants = restaurants;
	}
	
}
@JsonIgnoreProperties(ignoreUnknown = true)
class FoodRow{
	private String name;
	private double review_avg;
	public FoodRow() {}
	public FoodRow(String name, double review_avg) {
		this.name = name;
		this.review_avg = review_avg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getReview_avg() {
		return review_avg;
	}
	public void setReview_avg(double review_avg) {
		this.review_avg = review_avg;
	}
	
	
	
}


