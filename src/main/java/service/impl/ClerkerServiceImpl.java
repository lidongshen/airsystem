package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.ClerkerDao;
import entity.Flight;
import service.prototype.IClerkerService;

@Service("ClerkerServiceImpl")
public class ClerkerServiceImpl implements IClerkerService {

	@Autowired
	private  ClerkerDao clerkerdao;	
	
	@Override
	public List<Flight> seachFlightAll() {
		return clerkerdao.findFlightAll();
	}

	@Override
	public List<Flight> seachFlight(String from, String to) {	
		return clerkerdao.findFlight(from, to);
	}

	
	

}
