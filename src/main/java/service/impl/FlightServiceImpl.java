package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IFlightDao;
import entity.Flight;
import service.prototype.IFlightService;

@Service("flightServiceImpl")
public class FlightServiceImpl implements IFlightService{
	@Autowired
	private IFlightDao flightDao;
	
	@Override
	public List<Flight> seachFlightAll() {
		return flightDao.findFlightAll();
	}

	@Override
	public Flight seachFlight(int id) {
		return flightDao.findFlight(id);
	}

	@Override
	public void delFlight(int id) {
		flightDao.deleteFlight(id);
	}

	@Override
	public void addFlight(Flight flight) {
		flightDao.insertFlight(flight);
	}

	@Override
	public void modify(Flight flight) {
		flightDao.upDateFlight(flight);
	}

}
