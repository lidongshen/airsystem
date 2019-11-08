package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

import dao.prototype.IUserDao;
import entity.Flight;
import entity.Trip;
import entity.User;

@Repository("userDaoSpringImpl")
public class UserDaoSpringImpl implements IUserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Flight> order(int uId,String from, String to) {
		return jdbcTemplate.query(
				"select * from flight where f_id in (select f_id from outticket where o_id in (select o_id from trip where u_id = ?)) and f_fromcity = ? and f_tocity = ?",
				new Object[] {uId,from,to},
				new BeanPropertyRowMapper<Flight>(Flight.class));
		
	}

	@Override
	public List<Flight> findTicket(String from, String to) {
		return jdbcTemplate.query(
				"select * from flight where f_fromcity=? and f_tocity=?",
				new Object[] {from,to},
				new BeanPropertyRowMapper<Flight>(Flight.class));
	}

	@Override
	public void Pay(int uId, int fId) {
		jdbcTemplate.update(
				"update booking set b_count=b_count+1 where u_id=? and f_id=?",
				new Object[]{uId,fId});
		jdbcTemplate.update(
				"update table trip set u_ispay=1 where u_id=? and f_id=?",
				new Object[]{uId,fId});
	}
	
	@Override
	public boolean isPay(int uId,int fId) {
		boolean flag = false;
		Trip list = jdbcTemplate.queryForObject(
				"select * from trip where u_id=? and f_id=?", 
				new Object[] {uId,fId},
				new BeanPropertyRowMapper<Trip>(Trip.class));
		int trip = list.getuIspay();
		if(list.getuIspay()==1) {
			flag=true;
		}
		return flag;
	}

	@Override
	//出票
	public void drawer(int uId,int fId) {
		
	}

	@Override
	//退款
	public void refund(int uId,int fId) {
		
	}

	@Override
	//改签
	public void endorse(int uId,int fId,String from,String to) {
		
	}

	@Override
	public boolean isLogin(String username, String password) {
		boolean flag = false;
		List<User> list = jdbcTemplate.query(
				"select * from user where u_phone=? and u_password=?", 
				new Object[] {username,password},
				new BeanPropertyRowMapper<User>(User.class));
		if(list.size()>0) {
			flag=true;
		}
		return flag;
	}

	

}
