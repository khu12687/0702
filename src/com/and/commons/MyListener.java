package com.and.commons;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//웹서버가 가동될때, 하고싶은 작업이 있다면, 서버 가동, 중단을
//감지하는 이벤트를 제어할 수 있는 객체인 ContextLoaderListener
public class MyListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("저 가동되고있어요");
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("저 가요");
	}

}
