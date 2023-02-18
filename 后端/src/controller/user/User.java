package controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Result;
import pojo.UserInfo;
import service.UserService;

@Controller
@RequestMapping("/user")
public class User {
	@Autowired
	private UserService userService;


	@RequestMapping("/add")
	@ResponseBody
	public Result addUser(UserInfo user) {
		int rt = userService.addUser(user);
		return new Result(0, "", String.format("添加数据：%d 条", rt));
	}

	@RequestMapping("/list")
	@ResponseBody
	public Result listUser() {
		List<UserInfo> infos = userService.listUser();
		System.out.println("listUser");
		return new Result(0, "", infos);

	}

	@RequestMapping("/list2")
	@ResponseBody
	public Result listUser2() {
		List<UserInfo> infos = userService.listUser();
		System.out.println("listUser");
		return new Result(0, "22", infos);

	}

	@RequestMapping("/login")
	@ResponseBody
	public Result login(@RequestParam("account") String account, @RequestParam("password") String password) {
		UserInfo user;
		try {
			user = userService.checkUser(new UserInfo(account, password));
		} catch (NullPointerException e) {
			return new Result(0, "缺少参数", -1);
		} catch (Exception e) {
			return new Result(0, e.getMessage(), 0);
		}
		return new Result(0, "", 1);
	}

}
