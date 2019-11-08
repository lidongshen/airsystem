package service.prototype;

import java.util.List;

import entity.Flight;

public interface IUserService {

	List<Flight> order(int uId,String from,String to);
	
	boolean isLogin(String username,String password);
}
