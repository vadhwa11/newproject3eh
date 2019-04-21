package jkt.hrms.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class HelloWorldController extends MultiActionController {
	public ModelAndView show(HttpServletRequest req, HttpServletResponse res) {
		return new ModelAndView("helloworld");
	}

}
