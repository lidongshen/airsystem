package service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.Flight;
import service.prototype.IClerkerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=(TestConfig.class))
public class TestClerkerService {
	@Autowired
	private IClerkerService clerkerservice;
	
	@Test
	public void testFindAll() {
		List<Flight> f = clerkerservice.seachFlightAll();
		for (Flight f1 : f) {
			System.out.println(f1);
		}
	}
	@Test
	public void testFind() {
		List<Flight> f = clerkerservice.seachFlight("太原", "云南");
		for (Flight f1 : f) {
			System.out.println(f1);
		}
	}

}
