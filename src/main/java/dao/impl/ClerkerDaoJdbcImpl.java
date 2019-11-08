package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IClerkerDao;

import entity.Flight;
@Repository("ClerkerDaoJdbcImpl")
public class ClerkerDaoJdbcImpl  implements IClerkerDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	//查询全部航班
	public List<Flight> findFlightAll() {
		return jdbcTemplate.query("select * from flight", new BeanPropertyRowMapper<Flight>(Flight.class));
	}
	
	@Override
	//航班精确查询
	public List<Flight> findFlight(String from, String to) {
		return jdbcTemplate.query(
				"SELECT * FROM flight WHERE f_fromcity =? AND f_tocity=?",
				new Object[] {from,to},
				new BeanPropertyRowMapper<Flight>(Flight.class));
	}

	@Override
	//用户查询
	public void findUser(int uid) {
		
	}

	@Override
	//出票
	public void drawer(int uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//退票
	public void refund(int uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//改签
	public void endorse(int uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//支付
	public void pay(int uid) {
		// TODO Auto-generated method stub
		
	}
}
