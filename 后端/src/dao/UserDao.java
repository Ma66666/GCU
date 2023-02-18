package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import pojo.UserInfo;

@Repository("userDao")
@Mapper
public interface UserDao {
	/**
	 * �ӿڷ�����ӦSQLӳ���ļ�UserMapper.xml�е�id
	 */
	public UserInfo selectUserById(Integer uid);
	public List<UserInfo> selectAllUser();
	public int addUser(UserInfo user);
	public int updateUser(UserInfo user);
	public int deleteUser(Integer uid);
	public UserInfo selectUserByInfo(UserInfo user);
}
