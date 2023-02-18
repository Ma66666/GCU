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
			throw new Exception("��������");
		}
		UserInfo qu = userDao.selectUserByInfo(user);
		if(qu==null) {
			throw new Exception("�û������ڻ����벻ƥ��");
		}
		return qu;
		
	}
}
