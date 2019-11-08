package dao.prototype;

import java.util.List;

import entity.Flight;
/**
 * IUserDao接口
 * @author Administrator
 *
 */
public interface IUserDao {
	//查询订单
	List<Flight> order(int uId,String from,String to);
	
	//查余票
	List<Flight> findTicket(String from,String to);
	
	//出票
	void drawer(int uId);
	
	//退款
	void refund(int uId);
	
	//改签
	void endorse(int uId);
	
	//付账
	void pay(int uId);
	
	
	boolean isLogin(String username,String password);
}
