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
			throw new Exception("�ʺ����벻��Ϊ��");
		}
		AccountInfo qu = accountDao.selectAccountByInfo(account);
		if (qu == null) {
			throw new Exception("�û������ڻ����벻ƥ��");
		}
		return qu;

	}

	public int addAccount(AccountInfo account) throws Exception {
		if (account.getPassword().trim().isEmpty() || account.getAccountId().trim().isEmpty()
				|| account.getIphoneNumber().trim().isEmpty() || account.getAccountName().trim().isEmpty()) {
			throw new Exception("����û����д����");
		}
		try {
			int i = accountDao.addAccount(account);
		} catch (NullPointerException e) {
			throw new Exception("�ʺ��Ѿ�����~");
		} catch (Exception e) {
			throw new Exception("�ʺ��Ѿ�����~");
		}
		return 1;
	}

	public int updateAccount(AccountInfo account) throws Exception {
		if (account.getPassword().trim().isEmpty() || account.getAccountId().trim().isEmpty()
				|| account.getIphoneNumber().trim().isEmpty()) {
			throw new Exception("����û����д����");
		}
		int i = accountDao.updateAccount(account);
		if (i != 1) {
			throw new Exception("�ʺŻ����ֻ��������~");
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
