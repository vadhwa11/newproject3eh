package jkt.hms.util;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoadSalt implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Assume its HTTP
		HttpServletRequest httpReq = (HttpServletRequest) request;
		// Check the user session for the salt cache, if none is present we create one

		//Cache<String, Boolean> csrfPreventionSaltCache = (Cache<String, Boolean>)
		//httpReq.getSession().getAttribute("csrftoken");



		System.out.println(httpReq.getRequestURL()+"<<<url");
		String ref = httpReq.getHeader("Referer");
		System.out.println(ref+"<<<ref");
		if(ref==null ){
			chain.doFilter(request, response);

		}else if(ref.contains("framesetpopup") || ref.endsWith("/hms/")|| ref.toLowerCase().contains("jsp") || ref.contains("logout") || ref.contains("validate")){
			chain.doFilter(request, response);}
		else{
			String urll = ""+httpReq.getRequestURL();
			/*if(urll.toLowerCase().contains("jsp") || !urll.contains("jsp")){
		chain.doFilter(request, response);
	}else{*/
			String csrfToken =(String) httpReq.getSession().getAttribute("csrfToken");
			String ReqcsrfToken =(String) httpReq.getParameter("csrfToken");

			System.out.println("<<<r3ef");
			System.out.println(csrfToken+"  "+ReqcsrfToken);
			if (csrfToken.equals(ReqcsrfToken)){

				chain.doFilter(request, response);

			}

			else{
				throw new IOException();
				//RequestDispatcher rd=httpReq.getRequestDispatcher( httpReq.getSession().getServletContext().getRealPath("error.jsp"));
				//rd.forward(request, response);

				//}
			}

		}



	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}




}
