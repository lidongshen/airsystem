package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IUserDao;
import entity.Flight;
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
	public void pay(int uId) {
		
	}

	@Override
	public void drawer(int uId) {
		
	}

	@Override
	public void refund(int uId) {
		
	}

	@Override
	public void endorse(int uId) {
		
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
