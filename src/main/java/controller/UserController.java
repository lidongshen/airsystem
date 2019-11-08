package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Flight;
import service.prototype.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/search")
	public ModelAndView getUsers() {
		ModelAndView mv = new ModelAndView("user/list");
		List<Flight> f = userService.order(1, "太原" , "北京");
		mv.addObject("f",f);
		return mv;
	} 
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login/ulogin");
		return mv;
	}
	@RequestMapping("/logins")
	public ModelAndView loginplus(HttpServletRequest request) {
		ModelAndView mv = null;
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		if(userService.isLogin(uname,upwd)) {
			mv = new ModelAndView("user/index");
		}else {
			mv = new ModelAndView("user/login");
		}
		return mv;
	}
	
}
