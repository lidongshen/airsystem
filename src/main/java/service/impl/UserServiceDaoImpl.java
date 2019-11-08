package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IUserDao;
import entity.Flight;
import service.prototype.IUserService;

@Service
public class UserServiceDaoImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	@Override
	public List<Flight> order(int uId, String from, String to) {
		return userDao.order(uId, from, to);
	}
	@Override
	public boolean isLogin(String username, String password) {
		return userDao.isLogin(username, password);
	}
	@Override
	public List<Flight> findTicket(String from, String to) {
		return userDao.findTicket(from, to);
	}

}
