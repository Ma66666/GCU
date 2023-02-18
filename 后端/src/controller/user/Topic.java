package controller.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.TopicInfo;
import pojo.UserInfo;
import pojo.AccountInfo;
import pojo.Result;
import pojo.SectorInfo;
import service.ReplyService;
import service.SectorService;
import service.TopicService;

@Controller
@RequestMapping("/topic")
public class Topic {
	@Autowired
	private TopicService topicService;
	@Autowired
	SectorService sectorService;
	@Autowired
	ReplyService replyService;

	@RequestMapping("/list")
	@ResponseBody
	public Result listUser(@RequestParam("accountId") Integer accountId) {
		List<TopicInfo> infos = topicService.listTopic(accountId);
		return new Result(0, "", infos);

	}

	@RequestMapping("/allList")
	@ResponseBody
	public Result listUser() {
		List<TopicInfo> infos = topicService.allListTopic();
		return new Result(0, "", infos);

	}

	@RequestMapping("/sectorList")
	@ResponseBody
	public Result sectorList(Integer sectorId) {
		List<TopicInfo> infos = topicService.selectSectorTopic(sectorId);
		int i = sectorService.updateClickingRateNumber(sectorId);
		return new Result(0, "", infos);

	}

	@RequestMapping("/add")
	@ResponseBody
	public Result addUser(TopicInfo topicInfo) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(); // 获取当前时间
		String str = format.format(date);
		topicInfo.setTopicDate(str);
		try {
			int rt = topicService.addTopic(topicInfo);
		} catch (NullPointerException e) {
			return new Result(0, "资料未填写完整", 0);
		} catch (Exception e) {
			return new Result(0, e.getMessage(), 0);
		}
		int i = sectorService.updateTopicNumber(topicInfo.getSectorId());
		return new Result(0, "发帖成功", 1);
	}

	@RequestMapping("/delect")
	@ResponseBody
	public Result delectTopic(Integer topicId) {
		int rt = topicService.downTopic(topicId);
		rt = topicService.deleteTopic(topicId);
		if (rt != 0) {
			rt = replyService.deleteAllReply(topicId);
			return new Result(0, "删除成功", 1);
		} else
			return new Result(0, "删除失败,不存在这个帖子", 0);
	}

	@RequestMapping("/number")
	@ResponseBody
	public Result topicNumber() {
		int i = topicService.topicNumber();
		return new Result(0, "帖子总数", i);
	}

	@RequestMapping("/check")
	@ResponseBody
	public Result checkTopic(String topicName) {
		List<TopicInfo> list = topicService.checkTopic(topicName);
		return new Result(0, "模糊查询结果", list);
	}

}
