package cn.com.xc.customer.service;

import cn.com.xc.customer.model.User;

public interface UserService {
	// save
	public void saveUser(User user);

	// get
	public User getUserById(Long id);

}
