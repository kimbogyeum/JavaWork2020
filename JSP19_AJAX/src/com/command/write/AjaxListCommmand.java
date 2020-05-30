package com.command.write;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lec.beans.AjaxWriteListJson;
import com.lec.beans.AjaxWriteListXML;
import com.lec.beans.WriteDTO;

import sun.tracing.dtrace.DTraceProviderFactory;

public class AjaxListCommmand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// parameter 받아오기, 없으면 json 동작 디폴트로 
		String reqType=request.getParameter("reqType");
		if(reqType==null) reqType="json";
		
		//XML 혹은 JSON 으로 response 하기
		switch(reqType){
			case "xml":
				//responseXML(request, response); //jdom 사용
				responseXML2(request, response); //jdom 사용
				break;
//			case "json":
//				responseJSON(request, response); //org.json 사용
//				break;
			default:
				//responseJSON(request, response); 
				responseJSON2(request, response); 
		}//end switch

	}//end execute()
	
	
	private void responseJSON(HttpServletRequest request, HttpServletResponse response) {
		WriteDTO [] dtoArr = (WriteDTO [])request.getAttribute("list");
		JSONObject jsonOutput=new JSONObject(); //최종 결과는 object
		
		if(dtoArr==null) {
			jsonOutput.put("status", "FAIL");
		}else {
			jsonOutput.put("status","OK");
			int count=dtoArr.length;
			jsonOutput.put("count", count);
			
			//글목록
			JSONArray dataArr=new JSONArray(); //array
			for(int i=0; i<count; i++) {
				JSONObject dataObj=new JSONObject();
				
				dataObj.put("uid", dtoArr[i].getUid());
				dataObj.put("name", dtoArr[i].getName());
				dataObj.put("subject", dtoArr[i].getSubject());
				dataObj.put("content", dtoArr[i].getContent());
				dataObj.put("viewcnt", dtoArr[i].getViewCnt());
				dataObj.put("regdate", dtoArr[i].getRegDate());
				
				//array에 추가
				dataArr.put(dataObj);
			}
			
			jsonOutput.put("data", dataArr);
		}

		String jsonString = jsonOutput.toString(); //JSON 객체 --> String 변환
		response.setContentType("application/json charset=utf-8"); //MIME 설정
		
		try {
			response.getWriter().write(jsonString); //response 내보내기
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//end responseJSON()
	
	
	private void responseJSON2(HttpServletRequest request, HttpServletResponse response) {
		WriteDTO [] dtoArr=(WriteDTO []) request.getAttribute("list");
		
		AjaxWriteListJson list=new AjaxWriteListJson(); //response 할 Java 객체
		
		if(dtoArr ==null) {
			list.setStatus("Fail");
		}else {
			list.setStatus("OK");
			list.setCount(dtoArr.length);
			list.setList(Arrays.asList(dtoArr));
			
		}
		
		
		ObjectMapper mapper=new ObjectMapper(); //JSON으로 매핑할 Mapper 객체
		

			try {
				//Java -> JSON 문자열로 바꿔주기!
				String jsonString=mapper.writeValueAsString(list);
				response.setContentType("application/json; charset=utf-8"); //MIME 설정
				response.getWriter().write(jsonString);
				
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
	}
	
	
	private void responseXML(HttpServletRequest request, HttpServletResponse response) {
	
		WriteDTO [] dtoArr = (WriteDTO [])request.getAttribute("list");
		Document dom=new Document();
		Element rootElement= new Element("WriteList");//<WriteList>..</WriteList>라는 element 가 생김. 
		
		dom.setRootElement(rootElement);
		
		Element statusElement=new Element("status");
		if(dtoArr==null) {
			statusElement.setText("FAIL");
		}else {
			statusElement.setText("OK");
			
			//데이터 개수
			int count=dtoArr.length;
			Element countElement=new Element("Count")
					.setText(""+count)
					.setAttribute("id","ccc")
					.setAttribute("pw", "xxx");
			rootElement.addContent(countElement);
			
			for(int i=0; i<count; i++) {
				Element dataElement=new Element("Data");
				
				dataElement.addContent(new Element("uid").setText(dtoArr[i].getUid()+""));
				dataElement.addContent(new Element("name").setText(dtoArr[i].getName()+""));
				dataElement.addContent(new Element("subject").setText(dtoArr[i].getSubject()+""));
				dataElement.addContent(new Element("content").setText(dtoArr[i].getContent()+""));
				dataElement.addContent(new Element("viewcnt").setText(dtoArr[i].getViewCnt()+""));
				dataElement.addContent(new Element("regdate").setText(dtoArr[i].getRegDate()+""));
				
				rootElement.addContent(dataElement);
			}
		}
		rootElement.addContent(statusElement);
		
		//TODO
		XMLOutputter xmlOutputter=new XMLOutputter(Format.getPrettyFormat()); //Format.getPrettyFormat(): 콘솔에서 한줄로 안보이게 
		System.out.println(xmlOutputter.outputString(dom));
		try {
		response.setContentType("application/xml charset=utf-8");//text/> 
		response.getWriter().write(xmlOutputter.outputString(dom));//문자열로 만들어서 response
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}//end responseXML()

	
	private void responseXML2(HttpServletRequest request, HttpServletResponse response) {
		WriteDTO [] dtoArr=(WriteDTO []) request.getAttribute("list");
		
		AjaxWriteListXML list=new AjaxWriteListXML(); //response 할 Java 객체
		
		if(dtoArr==null) {
			list.setStatus("Fail");
		}else {
			list.setStatus("OK");
			list.setCount(dtoArr.length);
			list.setList(Arrays.asList(dtoArr));
		}//end if
		
		XmlMapper mapper=new XmlMapper(); //XML 매핑할 Mapper 객체
		
		try {
			//Java -> XML 문자열 변환
			String xmlString=mapper.writeValueAsString(list);
			response.setContentType("application/xml charset=utf-8");
			response.getWriter().write(xmlString);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//end responseXML2()
	
	
}
