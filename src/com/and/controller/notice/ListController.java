package com.and.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.and.controller.Controller;
import com.and.model.notice.NoticeDAO;
/*
 * 1단계 : 요청을 받는다
 * 2단계 : 요청을 분석ㅅ자
 * 3다꼐 : 알맞는 로직 객체에 일 시킨다(하위 컨트롤러_
 * 4단계 : 결과가 있다면, 결과 저장 (포워딩) (하위컨트롤러
 * 5단계 : 뷰를 보여준다 -상위 컨트롤러
 * */
public class ListController implements Controller{
	NoticeDAO noticeDAO= new NoticeDAO();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//3단계 : 일키시기!!
		List noticeList = noticeDAO.selectAll();
		
		//4단계 : jps
		request.setAttribute("list",noticeList);
	}

	@Override
	public boolean isForward() {
	
		return true;
	}

	@Override
	public String getViewPage() {

		return "/notice/view/list";
	}

}
