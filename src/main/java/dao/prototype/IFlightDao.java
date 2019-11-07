package dao.prototype;

import java.util.List;

import entity.Flight;

public interface IFlightDao {
	List<Flight> findFlightAll();
	Flight findFlight(int id);
	void deleteFlight(int id);
	void insertFlight(Flight flight);
	void upDateFlight(Flight flight);
	
}
