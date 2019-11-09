
package dao.prototype;

import java.util.List;

import entity.Flight;
import entity.User;

public interface IClerkerDao {
		List<Flight> findFlightAll();
		List<Flight> findFlight(String from,String to);
		List<User>  findUserAll();
		List<User>  findUser(int uid);
		void drawer(int uid);
		void refund(int uid);
		void endorse(int uid);
		void pay(int uid);	
}

