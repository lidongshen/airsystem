package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

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
	public String seachFlight(int page, int limit) {
		List<Flight> seachFlightAll = fs.flightPage(page, limit);
		int totalItems = fs.totalItems();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalItems);
		map.put("data", seachFlightAll);
		return JSON.toJSONString(map);
	}
	
	@RequestMapping(value="/del",produces="text/html;charset=utf-8")
	@ResponseBody
	public String delFlight(int fId) {
		int delFlight = fs.delFlight(fId);
		if(delFlight>0) {
			return "ok";
		}
		return "no";
	}
	
	@RequestMapping("/lookflight")
	public String lookFlight() {
		return "manager/lookflight";
	}
	
}

