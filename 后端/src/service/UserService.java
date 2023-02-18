package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import pojo.UserInfo;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public int addUser(UserInfo inf) {
		return userDao.addUser(inf);
	}
	
	public List<UserInfo> listUser() {
		return userDao.selectAllUser();
	}
	
	public UserInfo checkUser(UserInfo user) throws Exception {
		System.out.println(user);
		if(user.getPasswd().trim().isEmpty()|| user.getName().trim().isEmpty()) {
			throw new Exception("参数错误");
		}
		UserInfo qu = userDao.selectUserByInfo(user);
		if(qu==null) {
			throw new Exception("用户不存在或密码不匹配");
		}
		return qu;
		
	}
}
