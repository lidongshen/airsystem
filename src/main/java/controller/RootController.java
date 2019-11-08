package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import entity.Flight;
import service.prototype.IFlightService;

@Controller

public class RootController {
	@Autowired
	private IFlightService fs;
	
	@RequestMapping("/rindex")
	public String rindex(){
		return "manager/rindex";
	}
	@RequestMapping("/welcome")
	public String welcome(){
		return "manager/welcome";
	}
	
	@RequestMapping("/findex")
	public String findex(){
		return "manager/findex";
	}
	
	@RequestMapping(value="/fseach",produces="text/html;charset=utf-8")
	@ResponseBody
	public String seachFlight() {
		List<Flight> seachFlightAll = fs.seachFlightAll();
		System.out.println(JSON.toJSONString(seachFlightAll));
		return JSON.toJSONString(seachFlightAll);
	}
}

