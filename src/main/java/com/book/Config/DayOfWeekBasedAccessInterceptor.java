package com.book.Config;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
			
	//if this method returns true, the appliation will further handle the request.
		
		Calendar cal=Calendar.getInstance();
		int dayofweek=cal.get(cal.DAY_OF_WEEK);
		if(dayofweek==5)  //1 means sunday
		{
			response.getWriter().write("The website is closed today because today is Sunday");
			return false;
			
		}
		return true;
	}

}
