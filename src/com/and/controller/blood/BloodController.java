package com.and.controller.blood;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.and.controller.Controller;
import com.and.model.blood.BloodService;
import com.and.model.movie.MovieService;

public class BloodController implements Controller{
	BloodService bloodService;
	public BloodController() {
		bloodService = new BloodService();
	}
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//3단계 : 알맞는 비즈니스 로직 객체에 일 시킨다!!
		String blood = request.getParameter("blood");
		System.out.println("파라미터"+blood);
		String msg = bloodService.getAdivce(blood);
		
		System.out.println("모델 객체의 결과는 "+msg);
		//4단계 : 업무처리후 뷰로 가져갈게 있다면, 결과를 저장 (포워딩이 필요한 시점) 포워딩하자
		request.setAttribute("msg", msg);
		
	}
	//요청을 유지할지 여부
	public boolean isForward() {
		return true;
	}
	//어떤 jsp를 보여줄기
	public String getViewPage() {
		return "/view/blood";
	}
}
