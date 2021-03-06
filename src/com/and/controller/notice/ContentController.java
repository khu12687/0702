package com.and.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.and.controller.Controller;
import com.and.model.notice.Notice;
import com.and.model.notice.NoticeDAO;

public class ContentController implements Controller{
	NoticeDAO noticeDAO = new NoticeDAO();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//3단계 : 로직 객체에 일 시킨다!
		String notice_id = request.getParameter("notice_id");
		Notice notice = noticeDAO.select(Integer.parseInt(notice_id));
		System.out.println(notice.getTitle());
		//4단계 : 결과페이지인  jsp로 가져갈것이 있으므로 결과 저장
		request.setAttribute("notice", notice);
	}

	@Override
	public boolean isForward() {
		return true;
	}

	@Override
	public String getViewPage() {
		return "/notice/view/content";
	}

}
