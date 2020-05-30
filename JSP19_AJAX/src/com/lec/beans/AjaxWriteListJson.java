package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//POJO : Plain Old Java Object	

public class AjaxWriteListJson {
	int count; //데이터 개수
	String status; //처리결과
	
	@JsonIgnore
	String memo; //메모는 response에서 빠짐
	
	@JsonProperty("data") //Json property 이름과 Java 필드명이 다른경우
	List<WriteDTO> list;
	
	//Getter Setter
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List<WriteDTO> getList() {
		return list;
	}

	public void setList(List<WriteDTO> list) {
		this.list = list;
	}
	
	
	
	
	
	
}
