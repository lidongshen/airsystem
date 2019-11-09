package dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IUserDao;
import entity.Flight;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestUserDao {
	@Autowired
	private IUserDao userDao;
	@Test
	public void testOrder() {
		List<Flight> order = userDao.order(1, "太原", "北京");
		System.out.println(order);
	}
	@Test
	public void testFindTicket() {
		List<Flight> findTicket = userDao.findTicket("太原", "北京");
		System.out.println(findTicket);
	}
	@Test
	public void testLogin() {
		boolean flag = userDao.isLogin("123", "zss");
		System.out.println(flag);
	}
	@Test
	public void testIsPay() {
		boolean flag = userDao.isPay(1, 1);
		System.out.println(flag);
	}
}
