package jkt.hms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestFilter implements Filter{



	    @Override
	    public void destroy() {
	        // Do nothing
	    }

	    @Override
	    public void doFilter(ServletRequest req, ServletResponse res,
	            FilterChain chain) throws IOException, ServletException {

	            HttpServletRequest request = (HttpServletRequest) req;
	            HttpServletResponse response = (HttpServletResponse) res;
	           
	            chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);

	            // chain.doFilter(new XSSRequestWrapper(request), response);
		      
	    }

	    @Override
	    public void init(FilterConfig arg0) throws ServletException {
	        // Do nothing
	    }
	
	
}
