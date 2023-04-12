package com.example.demo6.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//인터페이스 구현
@Slf4j
@Component// 
public class GlobalFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1단계
//		log.error(">>>요청 (request) 에 대한 앞단 처리");
//		chain.doFilter(request, response);
//		log.error("<<<응답 (response)>>>>");
		
		//로깅처리 요청 URL 을 확인
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		log.error("요청 URL : {}"+ httpServletRequest.getRequestURI());
		chain.doFilter(httpServletRequest, response);
		log.error("응답 상태 : {}"+ httpServletResponse.getStatus());
	}

}
