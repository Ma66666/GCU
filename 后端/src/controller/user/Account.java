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

	// 用于登陆帐号的
	@RequestMapping("/login")
	@ResponseBody
	public Result loginAccount(AccountInfo account) {
		AccountInfo Account;
		try {
			Account = accountService.checkAccount(account);
		} catch (NullPointerException e) {
			return new Result(0, "缺少参数", -2);
		} catch (Exception e) {
			return new Result(0, e.getMessage(), -2);
		}
		return new Result(0,"查询结果",Account);
	}

	// 用于注册帐号的
	@RequestMapping("/add")
	@ResponseBody
	public Result addAccount(@RequestParam("accountId") String accountId, @RequestParam("password") String password,
			@RequestParam("iphoneNumber") String iphoneNumber, @RequestParam("accountName") String accountName, @RequestParam("accountPicture") String accountPicture) {
		try {
			// 若已存在就会返回空值
			int i = accountService.addAccount(new AccountInfo(accountId, password, iphoneNumber, accountName, "0",accountPicture));
		} catch (NullPointerException e) {
			return new Result(0, "资料未填写完整", 0);
		} catch (Exception e) {
			return new Result(0, e.getMessage(), 0);
		}
		return new Result(0, "注册成功", 1);
	}

	// 用于修改密码的
	@RequestMapping("/update")
	@ResponseBody
	public Result updateAccount(@RequestParam("accountId") String accountId, @RequestParam("password") String password,
			@RequestParam("iphoneNumber") String iphoneNumber) {
		try {
			int i = accountService.updateAccount(new AccountInfo(accountId, password, iphoneNumber));
		} catch (NullPointerException e) {
			return new Result(0, "资料未填写完整", 0);
		} catch (Exception e) {
			return new Result(0, e.getMessage(), 0);
		}
		return new Result(0, "修改成功", 1);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Result updateAccountStatus(String accountId) {
		int i = accountService.updateAccountStatus(accountId);
		if (i != 0)
			return new Result(0, "封号成功", 1);
		else
			return new Result(0, "封号失败", 0);
	}

	@RequestMapping("/resume")
	@ResponseBody
	public Result updateStatus(String accountId) {
		int i = accountService.updateStatus(accountId);
		if (i != 0)
			return new Result(0, "解封成功", 1);
		else
			return new Result(0, "解封失败", 0);
	}

	@RequestMapping("/list")
	@ResponseBody
	public Result accountList() {
		List<AccountInfo> list = accountService.accountList();
		return new Result(0, "用户和版主的帐号id,名字,电话号码,权限", list);
	}
	
	@RequestMapping("/up")
	@ResponseBody
	public Result upStatus(SectorInfo sector) {
		int i=accountService.upStatus(sector);
		i=sectorService.addSector(sector);
		if (i != 0)
			return new Result(0, "权限提升成功", 1);
		else
			return new Result(0, "权限提升失败", 0);
	}
	
	@RequestMapping("/down")
	@ResponseBody
	public Result downStatus(String accountId) {
		int i=accountService.downStatus(accountId);
		i=sectorService.downSector(accountId);
		if (i != 0)
			return new Result(0, "取消权限成功", 1);
		else
			return new Result(0, "取消权限失败", 0);
	}
}
