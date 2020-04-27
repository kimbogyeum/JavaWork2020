package phonebook04.list;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PhonebookModel {

//1. 멤버변수
	private int uid; //unique id
	private String name;
	private String phoneNum;
	private String memo;
	private Date regDate;//등록일
	
//2. 생성자	
//1)기본생성자
public PhonebookModel() {
	this.name = "";
	this.phoneNum = "";
	this.memo = "";
	this.regDate=new Date();//생성되는 현재시간
}
	
//2)매개변수 생성자
public PhonebookModel(String name, String phoneNum, String email) {
	this();//위에 this전체를 받는다.
	this.name = name;
	this.phoneNum = phoneNum;
	this.memo = email;
}
	
//3)uid, regDate 낀 생성자
public PhonebookModel(int uid, String name, String phoneNum, String email, Date regDate) {
	super();
	this.uid = uid;
	this.name = name;
	this.phoneNum = phoneNum;
	this.memo = email;
	this.regDate = regDate;
}

//3.getter & setter
	public int getUid() {return uid;}

	public void setUid(int uid) {this.uid = uid;}

	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}
	
	public String getPhoneNum() {return phoneNum;}
	
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	
	public String getMemo() {return memo;}
	
	public void setMemo(String memo) {this.memo = memo;}
	
	public Date getRegDate() {return regDate;}
	
	public void setRegDate(Date regDate) {this.regDate = regDate;}
	
	
	@Override
	public String toString() {
		String str=String.format("%3d | %s | %s | %s | %20s"
				,uid, name,phoneNum,memo,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate));
		//24시간이면 대문자
		return str;
	}

}

