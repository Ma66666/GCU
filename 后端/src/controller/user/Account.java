package controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.AccountInfo;
import pojo.Result;
import pojo.SectorInfo;
import service.AccountService;
import service.SectorService;

@Controller
@RequestMapping("/account")
public class Account {
	@Autowired
	private AccountService accountService;
	@Autowired
	private SectorService sectorService;

	// ���ڵ�½�ʺŵ�
	@RequestMapping("/login")
	@ResponseBody
	public Result loginAccount(AccountInfo account) {
		AccountInfo Account;
		try {
			Account = accountService.checkAccount(account);
		} catch (NullPointerException e) {
			return new Result(0, "ȱ�ٲ���", -2);
		} catch (Exception e) {
			return new Result(0, e.getMessage(), -2);
		}
		return new Result(0,"��ѯ���",Account);
	}

	// ����ע���ʺŵ�
	@RequestMapping("/add")
	@ResponseBody
	public Result addAccount(@RequestParam("accountId") String accountId, @RequestParam("password") String password,
			@RequestParam("iphoneNumber") String iphoneNumber, @RequestParam("accountName") String accountName, @RequestParam("accountPicture") String accountPicture) {
		try {
			// ���Ѵ��ھͻ᷵�ؿ�ֵ
			int i = accountService.addAccount(new AccountInfo(accountId, password, iphoneNumber, accountName, "0",accountPicture));
		} catch (NullPointerException e) {
			return new Result(0, "����δ��д����", 0);
		} catch (Exception e) {
			return new Result(0, e.getMessage(), 0);
		}
		return new Result(0, "ע��ɹ�", 1);
	}

	// �����޸������
	@RequestMapping("/update")
	@ResponseBody
	public Result updateAccount(@RequestParam("accountId") String accountId, @RequestParam("password") String password,
			@RequestParam("iphoneNumber") String iphoneNumber) {
		try {
			int i = accountService.updateAccount(new AccountInfo(accountId, password, iphoneNumber));
		} catch (NullPointerException e) {
			return new Result(0, "����δ��д����", 0);
		} catch (Exception e) {
			return new Result(0, e.getMessage(), 0);
		}
		return new Result(0, "�޸ĳɹ�", 1);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Result updateAccountStatus(String accountId) {
		int i = accountService.updateAccountStatus(accountId);
		if (i != 0)
			return new Result(0, "��ųɹ�", 1);
		else
			return new Result(0, "���ʧ��", 0);
	}

	@RequestMapping("/resume")
	@ResponseBody
	public Result updateStatus(String accountId) {
		int i = accountService.updateStatus(accountId);
		if (i != 0)
			return new Result(0, "���ɹ�", 1);
		else
			return new Result(0, "���ʧ��", 0);
	}

	@RequestMapping("/list")
	@ResponseBody
	public Result accountList() {
		List<AccountInfo> list = accountService.accountList();
		return new Result(0, "�û��Ͱ������ʺ�id,����,�绰����,Ȩ��", list);
	}
	
	@RequestMapping("/up")
	@ResponseBody
	public Result upStatus(SectorInfo sector) {
		int i=accountService.upStatus(sector);
		i=sectorService.addSector(sector);
		if (i != 0)
			return new Result(0, "Ȩ�������ɹ�", 1);
		else
			return new Result(0, "Ȩ������ʧ��", 0);
	}
	
	@RequestMapping("/down")
	@ResponseBody
	public Result downStatus(String accountId) {
		int i=accountService.downStatus(accountId);
		i=sectorService.downSector(accountId);
		if (i != 0)
			return new Result(0, "ȡ��Ȩ�޳ɹ�", 1);
		else
			return new Result(0, "ȡ��Ȩ��ʧ��", 0);
	}
}
