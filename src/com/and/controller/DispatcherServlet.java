package com.and.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.and.controller.blood.BloodController;
import com.and.controller.movie.MovieController;

/*웹어플리케이션의 enteryPoint 즉 진입점으로서,
모든 요청을 일단 혼자 다 받는다!!
일반적인 컨트롤러의 5대 업무 처리 프로세스
1)요청을 받는다
2)요청을 분석한다
3)알맞는 로직 객체에 일 시킨다
4)결과를 저장한다(단 저장할게 있을때만..)
5)결과를 보여준다
*/
public class DispatcherServlet extends HttpServlet{
	//서블릿이 태어난 후, 톰켓으로부터 얻고자 할 서블릿의 설정 정보 등이 있을때,
	//init 메서드 호출시 전달 될 수 있다
	FileInputStream fis;
	
	Properties props; //key - value 의 쌍으로 구성된 맵을 해석하는 객체
	@Override
	public void init(ServletConfig config) throws ServletException {
		String contextConfigLocation = config.getInitParameter("contextConfigLocation");
		
		//웹어플리케이션의 전반적, 전역전 정보를 가진 객체
		//ex) 어플리케이션의 하드디스크상 경로 등등..
		//jsp에서의 application 내장 객체다!!
		ServletContext context = config.getServletContext();
		String realPath = context.getRealPath(contextConfigLocation);
		System.out.println("매핑 파일의 위치는 "+realPath);
		try {
			fis = new FileInputStream(realPath);
			props = new Properties();
			props.load(fis); //이 시점부터 설정파일을 검색할 수 있다!!
			//즉 설정파일의 내용이 key-value로 되어있다면, Properties 객체의
			//검색 대상이된다
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);		
	}
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1단계 : 요청을 받는다(주문을 받는다!)
		request.setCharacterEncoding("utf-8");
		
		//2단계 : 요청을 분석한다!!(하위 컨트롤러를 결정하기 위함..)
		String uri = request.getRequestURI();
		String className = props.getProperty(uri);
		try {
			Class controllerClass = Class.forName(className);
			//클래스정보를 이용하여 하위 컨트롤러의 인스턴스 생성하자!!
			//MovieController controller =(MovieController)controllerClass.newInstance();
			BloodController controller = (BloodController)controllerClass.newInstance();
			controller.execute(request, response);
			
			//5단계 : 알맞는 뷰를 보여준다!!
			//요청을 끊고, 새로 접속?
			//요청을 유지?
			
			String viewKey = controller.getViewPage();
			String viewPage = props.getProperty(viewKey);
			if(controller.isForward()) { //요청을 유지할 경우
				RequestDispatcher dis = null;
				dis = request.getRequestDispatcher(viewPage);
				dis.forward(request, response);
			}else {//새롭게 다시 접속해야 될 경우
				response.sendRedirect(viewPage);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
	}
	public void destory() {
		if(fis!=null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
