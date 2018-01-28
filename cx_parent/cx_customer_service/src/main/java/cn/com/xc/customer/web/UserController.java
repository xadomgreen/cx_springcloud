package cn.com.xc.customer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.xc.common.http.ErrorCode;
import cn.com.xc.common.http.ResponseResult;
import cn.com.xc.customer.model.User;
import cn.com.xc.customer.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * UserController
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("${adminPath}/user")
@Api(value = "UserController")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("save") 
	@ApiOperation(notes = "保存User", value = "User") 
	public String save(@RequestBody User user) {
		userService.saveUser(user);
		return "保存User成功";
	}

	@GetMapping("get/{id}")
	@ApiOperation(notes = "查询User", value = "User")
	public ResponseResult<User> get(@PathVariable Long id) {
		ResponseResult<User> result = new ResponseResult<>();
		User user = userService.getUserById(id);
		result.setData(user);
		result.setErrcode(ErrorCode.OK);
		return result;
	}
}
