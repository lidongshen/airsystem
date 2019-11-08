package dao.prototype;

import java.util.List;

import entity.Flight;

public interface IClerkerDao {
		List<Flight> findFlightAll();
		List<Flight> findFlight(String from,String to);
		void  findUser(int uid);
		void drawer(int uid);
		void refund(int uid);
		void endorse(int uid);
		void pay(int uid);	
}
