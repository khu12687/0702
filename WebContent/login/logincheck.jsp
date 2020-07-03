<%@page import="com.and.model.member.MemberShip"%>
<%@page import="com.and.model.member.MemberShipDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%! MemberShipDAO dao = new MemberShipDAO(); %>
<%
	//웹서버에 의해 할당받은 세션번호를 확인해본다!!
	//jsp의 9개의 내장객체 중 session 이라는 객체가 정보를 담고 있다.
	out.print("내가 할당받은 세션 아이디 : "+session.getId());

	application.setAttribute("nick", "호랑이");
	
	//결론
	//javaEE에서 데이터를 저장하는 용도의 객체
	//request < session < application
	//파라미터를 넘겨받아, 회원여부 판단..
	//회원하면?? 마치 계속 연결이 유지된것처럼 서비스해준다!!
	//아니면? 욕!!
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	MemberShip ms = new MemberShip();
	ms.setId(id);
	ms.setPass(pass);
	
	MemberShip membership = dao.loginCheck(ms);
	if(membership!=null){
		System.out.println("회원이네용");
		session.setAttribute("member", membership);
%>
<a href ="/notice/list.do">게시판으로 이동</a>
<% 
	}else{
		System.out.println("가입하세요");
	}
%>