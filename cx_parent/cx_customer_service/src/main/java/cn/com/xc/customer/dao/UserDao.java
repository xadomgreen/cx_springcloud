package cn.com.xc.customer.dao;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.com.xc.customer.model.User;

@Repository
@Table(name = "user")
@Qualifier("userDao")
public interface UserDao extends CrudRepository<User, Long> {

	public User findOne(Long id);

	@SuppressWarnings("unchecked")
	public User save(User user);

	@Query("select t from User t where t.username=:name")
	public User findUserByName(@Param("name") String name);
}
