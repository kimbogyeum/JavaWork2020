package com.lec.java.crawl07;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * '검색어' 입력받아서
 * 첫페이지의 '국내도서' 첫페이지 20개 아이템 크롤링
 * 책 이름, 책 가격, 상세페이지 url, 썸네일 url
 */
public class Crawl07Main {
	private static final String PATH = "books";

	public static void main(String[] args) throws IOException {
		System.out.println("인터파크 도서 검색결과 페이지");

		Scanner sc = new Scanner(System.in);
		System.out.println("검색어를 입력하세요:");
		String search = sc.nextLine();
		sc.close();

		Crawl07Main app = new Crawl07Main();// ArrayList를 static으로 만들지 않았으니 생성자를 만들어줘야지!
		ArrayList<InfoBook> list = app.crawlInterPark(search);

		// 썸네일 이미지 다운로드 받아서
		// thumb001.jpg~thumb020.jpg...

		int fileIndex = 1;
		for (InfoBook e : list) { // list에 있는걸 옮기자, 크롤링 정보출
			System.out.println(e);
			// 썸네일 이미지 다운로드
			String fileName = String.format(PATH + File.separator + "thumb%03d.jpg", fileIndex);
			URL imgUrl = new URL(e.getImgUrl());
			BufferedImage imgData = ImageIO.read(imgUrl);
			File file = new File(fileName);
			ImageIO.write(imgData, "jpg", file);

			System.out.println(fileName + " 이 저장되었습니다.");

			fileIndex++;
		}

		System.out.println("\n 프로그램 종료");

	}// end main

	private ArrayList<InfoBook> crawlInterPark(String search) throws IOException {
		ArrayList<InfoBook> list = new ArrayList<InfoBook>(); // InfoBook의 리스트에 넣기

		String url;
		Document doc;
		Response response;
		Elements elements;
		Elements rowElements;

		url = "http://bsearch.interpark.com/dsearch/book.jsp?sch=all&sc.shopNo=&bookblockname=s_main&booklinkname=s_main&bid1=search_auto&bid2=product&bid3=000&bid4=001&query="
				+ URLEncoder.encode(search, "euc-kr");
		// System.out.println(url);

		doc = Jsoup.connect(url).execute().parse();

		rowElements = doc.select("#bookresult > form").get(0).select("div.list_wrap");
		System.out.println(rowElements.size() + "개");

		for (Element e : rowElements) {
			String imgUrl = e.selectFirst("div.bimgWrap >a>img").attr("src").trim();
			Element infoElement = e.selectFirst("div.info>p.tit>b>a");
			String bookTitle = infoElement.text().trim();
			String linkUrl = infoElement.attr("href").trim();
			System.out.println(bookTitle + ":" + linkUrl);// 확인용
			//내가 틀린부분!!!!!!!--------------------------------
			double price = Double.parseDouble(e.selectFirst("p.FnowCoupon > span.nowMoney").text().replace(",", "").split("원")[0].trim());
			//-----------------------------------------------
			System.out.println(price + "원");
			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
		}
		
		return list;
	}
}// end class
