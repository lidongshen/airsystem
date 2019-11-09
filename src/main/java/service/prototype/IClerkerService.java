package service.prototype;

import java.util.List;

import entity.Flight;
import entity.User;

public interface IClerkerService {
	List<Flight> seachFlightAll();
	List<Flight> seachFlight(String from,String to);
	List<User>seachUserAll();
	List<User>seachUser(int uid);
}
