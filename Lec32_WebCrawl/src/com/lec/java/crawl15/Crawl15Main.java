package com.lec.java.crawl15;
/* XML ,JSON 파싱연습
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


//
//이거 너무 편리한 기능이고 많이 쓰는 기능이다!!!!!!
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.spi.oa.OADefault;

public class Crawl15Main {

	public static void main(String[] args) throws IOException {
		System.out.println("jackson - databind 연습 2");

		ObjectMapper mapper = new ObjectMapper();
		URL url = new URL(
				"http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/%EC%84%9C%EC%9A%B8");
		Subway subway = mapper.readValue(url, Subway.class);

		for (SubRow e : subway.getstationList()) {
			System.out.printf(" %d: %s: %d: %s \n", e.getRowNum(), e.getStatnNm(), e.getSubwayId(), e.getSubwayNm());
		}

		System.out.println("\n 프로그램 종료");
	}// end main

}// end class

//stationList 배열 안에 바로 오브젝트니까 14Main과 다르게 class를 2개만 만들어야지. 
@JsonIgnoreProperties(ignoreUnknown = true)
class Subway {

	private List<SubRow> stationList;

	public List<SubRow> getstationList() {
		return stationList;
	}

	public void setRow(List<SubRow> stationList) {
		this.stationList = stationList;
	}	
	
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class SubRow {

	private int rowNum;
	private String statnNm;
	private int subwayId;
	private String subwayNm;

	public SubRow() {
	}

	public SubRow(int rowNum, String statnNm, int subwayId, String subwayNm) {
		super();
		this.rowNum = rowNum;
		this.statnNm = statnNm;
		this.subwayId = subwayId;
		this.subwayNm = subwayNm;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getStatnNm() {
		return statnNm;
	}

	public void setStatnNm(String statnNm) {
		this.statnNm = statnNm;
	}

	public int getSubwayId() {
		return subwayId;
	}

	public void setSubwayId(int subwayId) {
		this.subwayId = subwayId;
	}

	public String getSubwayNm() {
		return subwayNm;
	}

	public void setSubwayNm(String subwayNm) {
		this.subwayNm = subwayNm;
	}
}
