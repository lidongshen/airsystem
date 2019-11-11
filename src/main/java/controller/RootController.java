
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

	@RequestMapping("/rindex")
	public String rindex(){
		return "manager/rindex";
	}
	@RequestMapping("/welcome")
	public String welcome(){
		return "manager/welcome";
	}
	
}

