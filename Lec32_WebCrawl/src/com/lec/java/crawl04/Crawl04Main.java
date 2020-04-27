package com.lec.java.crawl04;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl04Main {

	public static void main(String[] args) throws IOException {//젤 최상위 오류인 IOException으로 그냥 다받아보리기 
		System.out.println("네이버 연관 검색어");
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		
		String searchKeyword;
		//입력받아서 url에 넣기
		Scanner sc=new Scanner(System.in);
		System.out.print("검색어를 입력하세요: ");
		searchKeyword=sc.nextLine();
		sc.close();
		
		String encoded=URLEncoder.encode(searchKeyword,"utf-8");//네이버 검색페이지는 utf-8로 encoding하더라 
		url="https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query="+encoded;
		System.out.println(url); //생성된 url을 확인해보자 
		
		doc=Jsoup.connect(url).execute().parse();
		
		Elements animal_elements=doc.select("ul._related_keyword_ul li a");//ul class안에 list안에 a
		System.out.println(animal_elements.size()+"개");
		
		for(Element e:animal_elements) {
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}
		
		System.out.println("\n 프로그램 종료");

	}

}
