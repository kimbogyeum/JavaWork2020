package com.lec.spring.aop02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.lec.beans.Logger;

//Aspect:Advisor 들을 모아놓은 객체 
//Advisor: Advice + Pointcut
//Advice: 공통기능 (메소드)


// ↓ 이 클래스가 Aspect 역할을 할 클래스임을 명시
@Aspect
public class LogAspect {
	
	//Pointcut 과 method 가 함께 지정된 메소드
	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc1() {}
	
	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc2() {}
//-------------------------------------------------------------------------------------------------------------------------------	

	//이거 하나가 Advisor이지~ //↓ 어떤 JoinPoint에 weaving 될지! (com.lec.spring.aop02아래의 어떤 메소드가 실행되더라도 그before에 이 메소드가 실행될것이다 라는 뜻)
	//@Before("within(com.lec.spring.aop02.*)")//PointCut
	@Before("pc1()")
	public void beforeAdvice() {
		System.out.print("[Before]");
		new Logger().logIn();//공통코드.Advice!원래는 doAction()이라는 핵심코드안에 있었잖아. 지금은 분리해준거야.
		//핵심코드가 실행될때 알아서 beforeAdvicer가 실행된게 weaving 된거야.	
	}
	
	//@After("within(com.lec.spring.aop02.*)")
	//@After("execution(* com.lec.spring.aop02.MyService22.*(..))")//*(..): 메소드는 뭐가 와도 관계없어 , MyService22클래스의 메소드에서만  After가 돌아가겠지!
	//@After("pc2()")
	@After("execution(* com.lec.spring.aop02.*2.*(..))")//2로 끝나는 class와 어떤 메소드든 상관 없음
	public void afterAdvice() {
		System.out.print("[After]");
		new Logger().logOut();
	}
	
	//Around advice: 메소드 실행을 제어하는 가장 강력한 코드, request response 응답시간 관리할때 쓰기 좋겠지?
	//	직접 해당 메소드를 호출하고 결과나 예외처리도 가능.
	@Around("within(com.lec.spring.aop02.*)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		//joinPoint 메소드 이름
		String signatureStr=joinPoint.getSignature().toShortString();
		
		
			//joinPoint 메소드 수행 전
			System.out.println("[Around]"+signatureStr+"시작");
			long st=System.currentTimeMillis(); //시작시간 기록
		
		try {
			//joinPoint 메소드 수행 중
			Object obj=joinPoint.proceed();
			return obj;
		}finally {
			//joinPoint 메소드 수행 후
			long et=System.currentTimeMillis();//종료시간 기록
			System.out.println("[Around]"+signatureStr+"종료. 경과시간(et-st):"+(et-st));
		}
	}
	
}
