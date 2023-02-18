package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AccountDao;
import pojo.AccountInfo;
import pojo.SectorInfo;

@Service
public class AccountService {
	@Autowired
	private AccountDao accountDao;

	public AccountInfo checkAccount(AccountInfo account) throws Exception {
		if (account.getPassword().trim().isEmpty() || account.getAccountId().trim().isEmpty()) {
			throw new Exception("帐号密码不能为空");
		}
		AccountInfo qu = accountDao.selectAccountByInfo(account);
		if (qu == null) {
			throw new Exception("用户不存在或密码不匹配");
		}
		return qu;

	}

	public int addAccount(AccountInfo account) throws Exception {
		if (account.getPassword().trim().isEmpty() || account.getAccountId().trim().isEmpty()
				|| account.getIphoneNumber().trim().isEmpty() || account.getAccountName().trim().isEmpty()) {
			throw new Exception("资料没有填写完整");
		}
		try {
			int i = accountDao.addAccount(account);
		} catch (NullPointerException e) {
			throw new Exception("帐号已经存在~");
		} catch (Exception e) {
			throw new Exception("帐号已经存在~");
		}
		return 1;
	}

	public int updateAccount(AccountInfo account) throws Exception {
		if (account.getPassword().trim().isEmpty() || account.getAccountId().trim().isEmpty()
				|| account.getIphoneNumber().trim().isEmpty()) {
			throw new Exception("资料没有填写完整");
		}
		int i = accountDao.updateAccount(account);
		if (i != 1) {
			throw new Exception("帐号或者手机号码错误~");
		}
		return i;

	}

	public int updateAccountStatus(String accountId) {
		int i = accountDao.updateAccountStatus(accountId);
		return i;
	}

	public int updateStatus(String accountId) {
		int i = accountDao.updateStatus(accountId);
		return i;
	}

	public List<AccountInfo> accountList() {
		return accountDao.accountList();
	}

	public int upStatus(SectorInfo sector) {
		int i = accountDao.upStatus(sector);
		return i;
	}

	public int downStatus(String accountId) {
		return accountDao.downStatus(accountId);
	}
}
