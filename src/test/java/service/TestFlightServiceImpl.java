//package service;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import config.TestConfig;
//import entity.Flight;
//import service.prototype.IFlightService;
//import util.DateUtil;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=(TestConfig.class))
//public class TestFlightServiceImpl {
//	@Autowired
//	private IFlightService fs;
//
//	@Test
//	public void testSeachAll() {
//		List<Flight> f = fs.seachFlightAll();
//		for (Flight f1 : f) {
//			System.out.println(f1);
//		}
//	}
//
//	@Test
//	public void testSeach() {
//		fs.modify(new Flight(2,"bo","太原","上海",1250,50,DateUtil.toDate("yyyy-MM-dd HH-mm-ss", "2019-11-02 11:54:20"),DateUtil.toDate("yyyy-MM-dd HH-mm-ss", "2019-11-02 13:54:20")));
//		System.out.println(fs.seachFlight(2));
//
//	}
//
//
//}
