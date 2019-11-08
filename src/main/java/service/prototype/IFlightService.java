package service.prototype;

import java.util.List;

import entity.Flight;

/**
 * 航班业务接口
 * @author s
 *
 */
public interface IFlightService {
	List<Flight> seachFlightAll();
	Flight seachFlight(int id);
	void delFlight(int id);
	void addFlight(Flight flight);
	void modify(Flight flight);
	List<Flight> flightPage(int pageNo,int pageSize);
}
