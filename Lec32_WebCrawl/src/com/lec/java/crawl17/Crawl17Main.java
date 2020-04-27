package com.lec.java.crawl17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sun.org.apache.xpath.internal.Arg;

/*
 * Selenium 라이브러리 다운로드 (Java 버젼으로!)
 * 	https://www.seleniumhq.org/download/
 * 
 *  BuildPath 추가
 *  
 * 브라우저 드라이버 다운로드 
 *  http://chromedriver.chromium.org/downloads
 *  
 *  
 */

public class Crawl17Main {

	// WebDriver
	private WebDriver driver;
	private WebElement element;
	private String url;
	
	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH = "D:/JavaApp1/download/chromedriver.exe";
	

	public static void main(String[] args) {
		System.out.println("Selenium 사용");
		
		Crawl17Main app = new Crawl17Main();
		app.init();
		//app.naverLogin();
		//app.likeFacebook();
		
		app.naverRelated("파이썬");
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	public void init() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		// Driver setup
		ChromeOptions options = new ChromeOptions();
		
		options.setCapability("ignoreProtectedModeSettings", true);
		driver = new ChromeDriver(options);	//제어되는 브라우저 가동!
		//driver를 통해서 브라우저 제어
		
	}
	
	public void naverLogin() {
		String url="http://nid.naver.com/nidlogin.login";
		driver.get(url); //url 주소로 이동
		
		//아이디 입력
		element=driver.findElement(By.id("id"));
//		System.out.println(element.getSize());
		element.sendKeys("kimbogyeum1"); //키보드 타이핑
		
		//패스워드 입력
		element=driver.findElement(By.id("pw"));
		element.sendKeys("qhruadl453?!");
		
		//로그인 버튼 클릭
		element=driver.findElement(By.className("btn_global"));
		element.click();
	}
	
	//Facebook 로그인 해보기 
	public void likeFacebook() {
		
		String url="https://ko-kr.facebook.com/";
		driver.get(url);//url 주소로 이동
		
		//아이디 , 비번, 로그인 버튼이 아닌 키보드 엔터
		driver.findElement(By.id("email")).sendKeys("kimbogyeum1@naver.com");
		driver.findElement(By.id("pass")).sendKeys("qhruadl453");
		driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(4000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		url="페북 특정 게시물 url";
		driver.get(url);//게시물로 이동
		//좋아요 element 찾기
		//좋아요 element 클릭하기 
		
	}

	
	//파이썬 연관검색어 크롤링해보기. 근데 selenium을 사용해서 해보기 
	public void naverRelated(String keyword) {
		driver.get("https://www.naver.com");
		driver.findElement(By.id("query")).sendKeys(keyword);
		driver.findElement(By.id("query")).sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> list=driver.findElements(By.cssSelector(".lst_relate ul li"));
		System.out.println(list.size()+"개");
		
		
		for(WebElement e:list) {
			System.out.println(e.findElement(By.tagName("a")).getText().trim());
		}
	}
	
	
	

} // end main








