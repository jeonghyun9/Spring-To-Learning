package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
// 필터를 적용할 요청의 패턴 지정 - 모든 요청에 필터를 적용
public class PerformanceFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		// TODO 초기화
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		// TODO 1. 전처리 작업
		long startTime = System.currentTimeMillis();
		
		// TODO 2. 서블릿 또는 다음 필터를 호출
		chain.doFilter(request, response);
		
		// TODO 3. 후처리 작업
		HttpServletRequest req = (HttpServletRequest) request;
		String referer = req.getHeader("referer");
		String method = req.getMethod();
		System.out.println("["+referer+"] ->"+ method + "["+req.getRequestURL()+"]");
		System.out.println("loading Time "+(System.currentTimeMillis()-startTime)+"ms");
		
	}
	
	@Override
	public void destroy() {
		// TODO 정리 작업
	}
	

}
