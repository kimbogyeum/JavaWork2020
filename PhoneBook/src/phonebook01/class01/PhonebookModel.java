package phonebook01.class01;

import java.text.SimpleDateFormat;
import java.util.Date;

//Model객체
//데이터 표현객체
public class PhonebookModel {

//1. 멤버변수
	private int uid; //unique id
	private String name;
	private String phoneNum;
	private String email;//메모
	private Date regDate;//등록일
	
//2. 생성자	
//1)기본생성자
public PhonebookModel() {
	this.name = "";
	this.phoneNum = "";
	this.email = "";
	this.regDate=new Date();//생성되는 현재시간
}
	
//2)매개변수 생성자
public PhonebookModel(String name, String phoneNum, String email) {
	this();//위에 this전체를 받는다.
	this.name = name;
	this.phoneNum = phoneNum;
	this.email = email;
}
	
//3)uid, regDate 낀 생성자
public PhonebookModel(int uid, String name, String phoneNum, String email, Date regDate) {
	super();
	this.uid = uid;
	this.name = name;
	this.phoneNum = phoneNum;
	this.email = email;
	this.regDate = regDate;
}

//3.getter & setter
	public int getUid() {return uid;}

	public void setUid(int uid) {this.uid = uid;}

	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}
	
	public String getPhoneNum() {return phoneNum;}
	
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	
	public String getEmail() {return email;}
	
	public void setEmail(String email) {this.email = email;}
	
	public Date getRegDate() {return regDate;}
	
	public void setRegDate(Date regDate) {this.regDate = regDate;}
	
	
	@Override
	public String toString() {
		String str=String.format("%3d | %s | %s | %s | %20s"
				,uid, name,phoneNum,email,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate));
		//24시간이면 대문자
		return str;
	}

}

