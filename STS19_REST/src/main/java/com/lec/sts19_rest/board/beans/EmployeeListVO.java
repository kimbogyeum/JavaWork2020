package com.lec.sts19_rest.board.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employees") //<employees> ~ </employees>
public class EmployeeListVO {
	
	// List 멤버 --> <emp> ~ </emp>..들로 만들어진다.
	@XmlElement 
	private List<EmployeeVO> emp =new ArrayList<EmployeeVO>();//바꿀 수 없는건 emp, emp의 내용은 바꿀 수 있어
	
	public List<EmployeeVO> getEmployees() {
		return emp;
	}
	
	
}
