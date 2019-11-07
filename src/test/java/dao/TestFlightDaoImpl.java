package dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IFlightDao;
import entity.Flight;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=(TestConfig.class))
public class TestFlightDaoImpl {
	@Autowired
	private IFlightDao fd;
	
	@Test
	public void testFindAll(){
		List<Flight> f = fd.findFlightAll();
		for (Flight f1 : f) {
			System.out.println(f1);
		}
	}
	
	@Test
	public void delete() {
		fd.deleteFlight(2);
	} 
	
	
	
	@Test
	public void find() {
		System.out.println(fd.findFlight(2));
	}
}
