package com.lec.sts19_rest.board.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee") //<employee>
public class EmployeeVO {
	
	@XmlAttribute		//"id" attribute
	private Integer id;
	@XmlElement			//"name" element
	private String name;
	@XmlElement			//<age> element
	private int age;
	@XmlElement			//<score> elements!
	private int[] score;
	//어노테이션 없으면 XML 변환에 포함안됨.
	private double point;
	
	//기본생성자 
	public EmployeeVO() {
		super();
	}



	//매개변수 생성자
	public EmployeeVO(Integer id, String name, int age, int[] score, double point) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
		this.point = point;
	}
	
	
	
	//Getter만 제공: readonly 속성, immutable
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int[] getScore() {
		return score;
	}
	public double getPoint() {
		return point;
	}
	
	
	
	
}
