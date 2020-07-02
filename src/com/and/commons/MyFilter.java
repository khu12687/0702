package com.and.commons;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//웹요청시 이 객체가 제일먼저 요청을 걸러낸다!!
//따라서 공통적으로 하고싶은 로직이나 수행할 코드가 있다면,
//여기서 처리할 수 있다..
public class MyFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("저 필터 태어나요"+filterConfig.getInitParameter("msg"));
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("저 다 들려요..요청 뺏었어요");
		chain.doFilter(request, response); //들어온 요청을 다시 진행 go ahead
		System.out.println("요청 뺏은 후 다시 보내 줄게요");
	}
	@Override
	public void destroy() {
		System.out.println("필터 갑니다..");		
	}

}
