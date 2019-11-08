package service.prototype;

import java.util.List;

import entity.Flight;

public interface IClerkerService {
	List<Flight> seachFlightAll();
	List<Flight> seachFlight(String from,String to);
}
