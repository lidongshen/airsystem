package dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.ClerkerDao;
import entity.Flight;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=(TestConfig.class))
public class TestClerkerDao {
	@Autowired
	private ClerkerDao clerkerdao;
	
	@Test
	public void testFindAll(){
		List<Flight> f = clerkerdao.findFlightAll();
		for (Flight f1 : f) {
			System.out.println(f1);
		}
	}
	@Test
	public void testFind() {
		List<Flight> f = clerkerdao.findFlight("太原", "北京");
		for (Flight f1 : f) {
			System.out.println(f1);
		}
	}

}
