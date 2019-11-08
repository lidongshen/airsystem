package dao.prototype;

import java.util.List;

import entity.Flight;

public interface IFlightDao {
	List<Flight> findFlightAll();
	List<Flight> findFlightPager(int offset ,int pageSize);
	Flight findFlight(int id);
	void deleteFlight(int id);
	void insertFlight(Flight flight);
	void upDateFlight(Flight flight);
	
}
