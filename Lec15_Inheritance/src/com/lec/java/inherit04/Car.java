package com.lec.java.inherit04;
//Vehicle 파일을 전부 주석처리한다면-> 1,2번은 멀쩡히 돌아간다. 
//왜냐하면 기본적으로 생성자는 만들어주니까!3번이 안되는 이유는 Vehicle(int)가 없기 때문
public class Car extends Vehicle {

	int oil;
	//1
	public Car() {
		//부모클래스의 생성자 호출---> Vehicle()
		//명시적인 super 생성자가 없으면 부모의 기본 생성자를 호출하게 됨. 
		System.out.println("Car() 생성");
	}
	
	//2
	public Car(int oil) {
		//super()는 반드시 생성자 코드의 첫번째 문장이어야 함. 
		super(); //super:부모를 의미, supper()<--부모의 기본생성자 호출
		this.oil=oil; //이거왜하는거지?
		System.out.println("Car(int)생성: oil="+oil);
	}
	
	//3
	public Car(int speed, int oil) {
		super(speed); //super(int)<---부모생성자 호출
		this.oil=oil;
		System.out.println("Car(int,int) 생성: speed="+speed+" oil="+oil);
	}
	
	public Car(double value) {
		this(555,(int)value); //생성자 위임(delegation)
		// this 랑 super은 양립할 수 없다. 
		System.out.println("Car(double)생성: value="+value);
	}
}
