package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoginController {
	
	@RequestMapping("/rlogin")
	public String rlogin() {
		return "login/rlogin";
	}
	@RequestMapping("/ulogin")
	public String ulogin() {
		return "login/ulogin";
	}
	
}
