package cn.com.xc.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.xc.customer.dao.UserDao;
import cn.com.xc.customer.model.User;
import cn.com.xc.customer.service.UserService;

/**
 * User Service Impl
 * 
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userDao.findOne(id);
	}

}
