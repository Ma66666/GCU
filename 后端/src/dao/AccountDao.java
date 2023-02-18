package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import pojo.AccountInfo;
import pojo.SectorInfo;

@Repository("accountDao")
@Mapper
public interface AccountDao {
	// 查询帐号密码是否正确 用于登陆的
	public AccountInfo selectAccountByInfo(AccountInfo account);

	// 用于注册功能
	public int addAccount(AccountInfo account);

	// 用于修改密码功能
	public int updateAccount(AccountInfo account);

	// 封号
	public int updateAccountStatus(String accountId);

	// 解封
	public int updateStatus(String accountId);

	// 查看所有帐号
	public List<AccountInfo> accountList();
	
	//提升权限
	public int upStatus(SectorInfo sector);
	
	//取消权限
	public int downStatus(String accountId);
}
