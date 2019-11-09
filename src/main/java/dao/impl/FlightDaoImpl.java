package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IFlightDao;
import entity.Flight;

@Repository("flightDaoImpl")
public class FlightDaoImpl implements IFlightDao{
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<Flight> findFlightAll() {
		return jt.query("select * from flight", new BeanPropertyRowMapper<Flight>(Flight.class));
	}

	@Override
	public void deleteFlight(int id) {
		jt.update("delete from flight where f_id="+id);
	}

	@Override
	public Flight findFlight(int id) {
		return jt.queryForObject("select * from flight where f_id="+id,new BeanPropertyRowMapper<Flight>(Flight.class));
	}

	@Override
	public void insertFlight(Flight flight) {
		jt.update("insert into flight(f_name,f_fromcity,f_tocity,f_money,f_seatnum,f_startdate,f_enddate) values(?,?,?,?,?,?,?)",new Object[] {flight.getfName(),flight.getfFromcity(),flight.getfTocity(),flight.getfMoney(),flight.getfSeatnum(),flight.getfStartdate(),flight.getfEnddate()});
	}

	@Override
	public void upDateFlight(Flight flight) {
		jt.update("update flight set f_name=?,f_fromcity=?,f_tocity=?,f_money=?,f_seatnum=?,f_startdate=?,f_enddate=? where f_id=?",new Object[] {flight.getfName(),flight.getfFromcity(),flight.getfTocity(),flight.getfMoney(),flight.getfSeatnum(),flight.getfStartdate(),flight.getfEnddate(),flight.getfId()});
	}

	@Override
	public List<Flight> findFlightPager(int offset, int pageSize) {
		return jt.query("select * from flight limit ?,?",new Object[] {offset,pageSize}, new BeanPropertyRowMapper<Flight>(Flight.class));
	}
	
	
}
