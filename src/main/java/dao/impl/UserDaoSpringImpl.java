package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.prototype.IUserDao;
import entity.Flight;
import entity.OutTicket;
import entity.Trip;
import entity.User;

@Repository("userDaoSpringImpl")
public class UserDaoSpringImpl implements IUserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional
	public void orderTicket(int uId, int fId) {
		
		jdbcTemplate.update("insert into booking (u_id,c_id,f_id,b_ispay) values("+uId+",0,"+fId+",0)");
		
		jdbcTemplate.update("insert into trip (u_id,f_id,u_ispay) values("+uId+","+fId+",0)");
	}
	//出票
	@Override
	public void drawerTicket(int uId, int fId) {
		jdbcTemplate.update(
				"insert into outticket (u_id,f_id,c_id,o_isout) values(?,?,0,1)",
				new Object[] {uId,fId});
	}
	//退票
	@Override
	@Transactional
	public void refundTicket(int uId, int fId) {
		jdbcTemplate.update(
				"update trip set u_ispay=0 where u_id=? and f_id=?",
				new Object[] {uId,fId});
		jdbcTemplate.update(
				"update booking set b_ispay=0 where u_id=? and f_id=?",
				new Object[] {uId,fId});
		jdbcTemplate.update(
				"update outticket set o_isout=0 where u_id=? and f_id=?",
				new Object[] {uId,fId});
	}
	//改签
	@Override
	@Transactional
	public void endorseTicket(int uId, int fId1,int fId2) {
		jdbcTemplate.update(
				"update trip set f_id = ? where u_id = ? and f_id=?",
				new Object[] {fId2,uId,fId1});
		jdbcTemplate.update(
				"update booking set f_id = ? where u_id = ? and f_id=?",
				new Object[] {fId2,uId,fId1});
	}

	@Override
	public void pay(int uId, int fId) {
		jdbcTemplate.update(
				"update trip set u_ispay=1 where u_id=? and f_id=?",
				new Object[]{uId,fId});
	}

	@Override
	public List<Flight> findOrder(int uId, String from, String to) {
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
	public boolean isPay(int uId, int fId) {
		boolean flag = false;
		Trip list = jdbcTemplate.queryForObject(
				"select * from trip where u_id=? and f_id=?", 
				new Object[] {uId,fId},
				new BeanPropertyRowMapper<Trip>(Trip.class));
		if(list.getuIspay()==1) {
			flag=true;
		}
		return flag;
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
	@Override
	public boolean isOutTicket(int uId,int fId) {
		boolean flag = false;
		OutTicket list = jdbcTemplate.queryForObject(
				"select * from outticket where u_id=? and f_id=?", 
				new Object[] {uId,fId},
				new BeanPropertyRowMapper<OutTicket>(OutTicket.class));
		if(list.getoIsout()==1) {
			flag=true;
		}
		return flag;
	}
	@Override
	public void saveOrUpdateBooking(int uId, int fId, int bIspay) {
		
	}
	@Override
	public void saveOrUpdateTrip(int uId, int fId, int uIspay) {
		
	}
	@Override
	public void saveOrUpdateOutTicket(int uId, int fId, int oIsout) {
		
	}
	
	
	

}
