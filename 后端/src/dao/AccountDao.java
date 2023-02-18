package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import pojo.AccountInfo;
import pojo.SectorInfo;

@Repository("accountDao")
@Mapper
public interface AccountDao {
	// ��ѯ�ʺ������Ƿ���ȷ ���ڵ�½��
	public AccountInfo selectAccountByInfo(AccountInfo account);

	// ����ע�Ṧ��
	public int addAccount(AccountInfo account);

	// �����޸����빦��
	public int updateAccount(AccountInfo account);

	// ���
	public int updateAccountStatus(String accountId);

	// ���
	public int updateStatus(String accountId);

	// �鿴�����ʺ�
	public List<AccountInfo> accountList();
	
	//����Ȩ��
	public int upStatus(SectorInfo sector);
	
	//ȡ��Ȩ��
	public int downStatus(String accountId);
}
