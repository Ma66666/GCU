package controller.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Result;

@Controller
public class Error {
	@RequestMapping("/error")
	@ResponseBody
	public Result needPermission(HttpServletRequest request) {
		Object tips = request.getAttribute("tips");
		System.out.println(tips);
		return new Result(-1, String.format("需要管理员权限:%s", tips), "");
	}
}
