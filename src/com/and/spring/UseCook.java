package com.and.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseCook {
	
	public static void main(String[] args) {
		//스프링 설정 xml 파일로부터 빈(자바의 객체)들을 생성해보자!!
		//xml의 위치가 패키지 경로에 있으므로, ApplicationContext의
		//구현 객체 중에서 ClasspathXMLApplicationContext 이용하자 
		//뭔데 xml을 해석하여 , 실제 자바 객체화 시켜준다!!
		ClassPathXmlApplicationContext applicationContext = null;
		applicationContext = new ClassPathXmlApplicationContext("com/and/spring/context.xml");
		
		//생성자에 의해 xml에 명시된 bean객체들의 인스턴스가 이미 올라간다!!
		Pan pan = (Pan)applicationContext.getBean("fripan");
		Cook cook = (Cook)applicationContext.getBean("cook");
		cook.work();
		
	}
}
