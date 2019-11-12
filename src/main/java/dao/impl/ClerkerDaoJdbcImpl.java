package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IClerkerDao;
import entity.Flight;
import entity.User;
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
	//查询航班详细信息
	public List<Flight> findFlightinfo(int fid) {
		return jdbcTemplate.query(
				"SELECT * FROM flight WHERE f_id=?",
				new Object[] {fid},
				new BeanPropertyRowMapper<Flight>(Flight.class));
	}
	
	@Override
	//全部用户信息查询
	public List<User> findUserAll() {
		return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
	}
	@Override
	//单用户信息查询
	public List<User> findUser(int uid) {
		return jdbcTemplate.query("SELECT * FROM user WHERE u_id=?", new Object[] {uid},new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	//订票
	public void orderTicket(int uId, int fId) {
		
		jdbcTemplate.update("insert into booking (u_id,c_id,f_id,b_ispay) values("+uId+",0,"+fId+",0)");
		
		jdbcTemplate.update("insert into trip (u_id,f_id,u_ispay) values("+uId+","+fId+",0)");
	}

		@Override
		//出票
		public void drawerTicket(int uId, int fId) {
			jdbcTemplate.update(
					"insert into outticket (u_id,f_id,c_id,o_isout) values(?,?,0,1)",
					new Object[] {uId,fId});
		}

		//退票
		@Override
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

		@Override
		//改签
		public void endorseTicket(int uId, int fId1,int fId2) {
			jdbcTemplate.update(
					"update trip set f_id = ? where u_id = ? and f_id=?",
					new Object[] {fId2,uId,fId1});
			jdbcTemplate.update(
					"update booking set f_id = ? where u_id = ? and f_id=?",
					new Object[] {fId2,uId,fId1});
		}


		@Override
		//支付
		public void pay(int uId, int fId) {
			jdbcTemplate.update(
					"update trip set u_ispay=1 where u_id=? and f_id=?",
					new Object[]{uId,fId});
		}

	@Override
	//修改用户信息
	public void Modify(int uid) {
		jdbcTemplate.update("update ");
	}
}

