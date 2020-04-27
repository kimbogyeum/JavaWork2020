package com.lec.java.crawl01;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * 외부 라이브러리를 사용한 자바 프로젝트
 * 
 * 1. 라이브러리 다운로드
 * 
 * 2. 프로젝트내(혹은 특정경로)에 라이브러리 저장
 * 
 * 3. 프로젝트의 Build Path 설정
 * 
 */

/*
 * 같은 패키지안에 있는거면 import안해도됨. java.lang 안에 있는거도 import 안해도됨.
 * 1.http://jsoup.org/ 에서 다운
 * 2.프로젝트에 libs 폴더만들고(ex:libs)라이브러리 복사
 * 3.프로젝트 우클릭-Configure Build Path-Library탭-Add Jars(혹은 라이브러리 추가)-추가할 라이브러리선택
 */

/*
 * 네이버 뉴스캐스트(상단의 실시간 뉴스)
 * 
 * 
 */


public class Crawl01Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 뉴스 캐스트 크롤링");
		//String name;//만약 Lec32_WebCrawl에 jre Library지우면 String이고 나발이고 다 에러뜨지
		String url; //크롤링할 주소 url
		Response response;//response 객체
		Document doc; //JSOUP의 document object model 객체 
		Element element;
		
		url="http://www.naver.com";
		response=Jsoup.connect(url).execute();
		//GET 방식 request는 다음과 같이 해도 된다. 
		//Jsoup.connect(url).get();
		System.out.println(response.statusCode());
//		request 결과코드
//		200 성공
//		404 url 존재하지 않음
//		500 서버 내부 
//		400 Bad Request : request 문법상의 오류
//		401 권한에러 : 권한 관현 적절한 header 정보가 없는 경우 많이 발생
//		402 권한에러 : 자원에 대한 접근 권한 에러
//		403  권한에러 Forbidden : 파일권한, 읽기권한, SSL, IP, 등...  <--- 웹 크롤링 하다가 은근히 자주 마주치게 되는 에러
	
		System.out.println(response.statusMessage());
		
		doc=response.parse();
		
		System.out.println(doc.title());//<title> element의 텍스트;
		System.out.println(doc.location());//현재 웹문서의 url
		
		String outerHtml=doc.outerHtml();//현재 node의 outer html 텍스트
//		System.out.println(outerHtml);
		System.out.println(outerHtml.substring(0,200)+"...");
//----------------------------------------------------------------------여기까지는 이런게있다는정도만----------
		//Document 나 Element객체의 
		//select(),selectFirst() 메소드로 특정 element(들)을 추출
		System.out.println("[네이버 뉴스 케스트]");
		
		element= doc.selectFirst("#news_cast");//검색된 element들 중 최초 1개만 Element로 리턴
		//System.out.println(element.outerHtml());
		
		Elements newsElements=doc.select("#news_cast li.ca_item");//ca_item을 갖고있는 li들, 검색된 Element들이 담겨있는 Elements리턴
		//목록 크롤링 할시, 내가 원하는 개수만큼 크롤링 되었는지 우선 확인해보자
		
		System.out.println(newsElements.size()+"개");
		
		for(Element e:newsElements) {
			//System.out.println(e.outerHtml());
			element= e.selectFirst("a");
			System.out.println(element.text()); //element의 text()-> text들을 묶어서 하나로 리턴
			System.out.println(element.attr("href"));
		}
		
		System.out.println("\n프로그램 종료");
		
	}//end main

}//end class
