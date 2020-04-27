package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */


/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요 
// JSON 은  jackson 을 활용하여 파싱하세요


public class DailySumMain {
	
	public static final String REQ_SERVICE="SPOP_DAILYSUM_JACHI";
	public static final String API_KEY="4d69736a736b696d383449726d6f6f";

	public static void main(String[] args) throws IOException {
		System.out.println("[XML]");
		String url=buildAdress("xml", 1, 5, "20190101");
	
	Document doc=Jsoup.connect(url).parser(Parser.xmlParser()).get();
	Elements elements=doc.select("row");
	
	System.out.println("날짜             구ID        총생활인구수           일최대이동인구수");
	System.out.println("----------------------------------------------------------------------");
	
	for(Element e: elements) {
		String STDR_DE_ID=e.selectFirst("STDR_DE_ID").text().trim();
		String SIGNGU_CODE_SE=e.selectFirst("SIGNGU_CODE_SE").text().trim();
		String TOT_LVPOP_CO=e.selectFirst("TOT_LVPOP_CO").text().trim();
		String LNGTR_STAY_FRGNR_CO=e.selectFirst("LNGTR_STAY_FRGNR_CO").text().trim();
		
		System.out.printf("%s  %s   %s   %s\n",STDR_DE_ID,SIGNGU_CODE_SE,TOT_LVPOP_CO,LNGTR_STAY_FRGNR_CO);
	}
	System.out.println();
	System.out.println("[JSON]");
	System.out.println("날짜             구ID        총생활인구수           일최대이동인구수");
	System.out.println("----------------------------------------------------------------------");
	ObjectMapper mapper = new ObjectMapper();
	URL url1=new URL("http://openapi.seoul.go.kr:8088/4d69736a736b696d383449726d6f6f/json/SPOP_DAILYSUM_JACHI/1/5/20190101");

	
	Seoul seoul=mapper.readValue(url1, Seoul.class);
		
	for (SeoRow a : seoul.SPOP_DAILYSUM_JACHI().getRow() ) {
		System.out.printf("%s  %s   %s   %s\n", a.getDate(),a.getGucode(),a.getTotal(),a.getOneday());
	}

	} // end main

	public static String buildAdress(String reqType,int startIndex, int endIndex,String date) {
		String url_adress=String.format("http://openapi.seoul.go.kr:8088/%s/%s/SPOP_DAILYSUM_JACHI/%d/%d/%s"
				,API_KEY,reqType,startIndex,endIndex,date);
		return url_adress;
	}
} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Seoul{
	public Stats SPOP_DAILYSUM_JACHI;
	
	public Stats SPOP_DAILYSUM_JACHI() {
		return SPOP_DAILYSUM_JACHI;
	}

	public void setSPOP_DAILYSUM_JACHI(Stats sPOP_DAILYSUM_JACHI) {
		this.SPOP_DAILYSUM_JACHI = sPOP_DAILYSUM_JACHI;
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Stats{
	private int list_total_count;
	private List<SeoRow> row;
	
	public List<SeoRow> getRow() {
		return row;
	}
	public void setRow(List<SeoRow> row) {
		this.row = row;
	}
	
	public int getList_total_count() {
		return list_total_count;
	}
	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}
	
}


@JsonIgnoreProperties(ignoreUnknown = true)
class SeoRow{
	@JsonProperty("STDR_DE_ID")
	private String date;
	@JsonProperty("SIGNGU_CODE_SE")
	private String gucode;
	@JsonProperty("TOT_LVPOP_CO")
	private String total;
	@JsonProperty("LNGTR_STAY_FRGNR_CO")
	private String oneday;
	
	public SeoRow() {}

	public SeoRow(String date, String gucode, String total, String oneday) {
		super();
		this.date = date;
		this.gucode = gucode;
		this.total = total;
		this.oneday = oneday;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGucode() {
		return gucode;
	}

	public void setGucode(String gucode) {
		this.gucode = gucode;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getOneday() {
		return oneday;
	}

	public void setOneday(String oneday) {
		this.oneday = oneday;
	}
	
	
	

	
	
	

	

	
	
	
}
