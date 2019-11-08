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
	
	//查票
	List<Flight> findTicket(String from,String to);
	
	//出票
	void drawer(int uId,int fId);
	
	//退款
	void refund(int uId,int fId);
	
	//改签
	void endorse(int uId,int fId,String from,String to);
	
	//付账
	void Pay(int uId, int fId);
	//检查是否付账
	boolean isPay(int uId,int fId);
	
	
	boolean isLogin(String username,String password);
}
