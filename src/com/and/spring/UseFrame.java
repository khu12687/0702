package com.and.spring;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseFrame {
	
	public static void main(String[] args) {
		/*
		 * applicationContext의 역할?
		 * xml에 명시한 빈들을 대상으로 인스턴스를 생성하고, 이들간의
		 * weaviong관계가 있다면 ,알아서 구현
		 *applicationContest 가 메모리에 생성될떄, xml에 명시된 모든빈들도
		 *함께 메모리에 올라간다
		 * */
		ClassPathXmlApplicationContext applicationContext=null;
		applicationContext = new ClassPathXmlApplicationContext("com/and/spring/gui.xml");
		
		MyFrame myFrame = (MyFrame)applicationContext.getBean("myFrame");
		myFrame.init();
	}
}
