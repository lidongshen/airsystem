package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Flight;
import service.prototype.IFlightService;
import service.prototype.IUserService;

@Controller
@RequestMapping(value = "/user",produces = "text/plain;charset=utf-8")
public class UserController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IFlightService flightService;
	
	@RequestMapping(value = "/search",produces = "text/plain;charset=utf-8")
	public ModelAndView getUsers(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String from = request.getParameter("from");
		String to = request.getParameter("to");		
		ModelAndView mv = new ModelAndView("user/list");
		List<Flight> f = userService.findTicket(from, to);
		mv.addObject("f",f);
		return mv;
	} 
	
	@RequestMapping(value = "/login",produces = "text/plain;charset=utf-8")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login/ulogin");
		return mv;
	}
	@RequestMapping(value = "/logins",produces = "text/plain;charset=utf-8")
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
	@RequestMapping(value ="/userLookFlight/{fId}",produces = "text/plain;charset=utf-8")
	public ModelAndView userLookFlight(@PathVariable("fId") int fId) {
		ModelAndView mv = new ModelAndView("user/details");
		Flight oneFlight = flightService.seachFlight(fId);
		mv.addObject("oneFlight", oneFlight);
		return mv;
	}
	@RequestMapping(value="/payTicket/{fId}",produces = "text/plain;charset=utf-8")
	public ModelAndView payTicket(@PathVariable("fId") int fId) {
		ModelAndView mv = new ModelAndView("user/pay");
		Flight flight = flightService.seachFlight(fId);
		double ticketPrice =flight.getfMoney();
		mv.addObject("ticketPrice", ticketPrice);
		return mv;
	}
	@RequestMapping(value="/orderTicket/{fId}",produces = "text/plain;charset=utf-8")
	public ModelAndView orderTicket(@PathVariable("fId") int fId,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("user/orderTicket");
		int uId;
		return mv;
	}
}
