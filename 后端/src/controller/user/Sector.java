package controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Result;
import pojo.SectorInfo;
import service.ReplyService;
import service.SectorService;
import service.TopicService;

@Controller
@RequestMapping("/sector")
public class Sector {
	@Autowired
	private SectorService sectorService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private ReplyService replyService;

	@RequestMapping("/list")
	@ResponseBody
	public Result checkSector(Integer accountId) {
		List<SectorInfo> infos = sectorService.checkSector(accountId);
		return new Result(0, "", infos);

	}

	@RequestMapping("/allList")
	@ResponseBody
	public Result checkAllSector() {
		List<SectorInfo> infos = sectorService.checkAllSector();
		return new Result(0, "", infos);

	}

	@RequestMapping("/delect")
	@ResponseBody
	public Result delectSector(String sectorName) {
		int i = replyService.deleteSectorReply(sectorName);
		i = topicService.deleteAlltopic(sectorName);
		i = sectorService.deleteSector(sectorName);
		if (i != 0) {
			return new Result(0, "板块删除成功", 1);
		} else
			return new Result(0, "板块删除失败", 0);
	}

	@RequestMapping("/allName")
	@ResponseBody
	public Result checkSectorName() {
		List<String> list = new ArrayList<String>();
		list.add("全部");
		List<String> list1 = sectorService.checkName();
		for (int i = 0; i < list1.size(); i++) {
			list.add(list1.get(i));
		}
		return new Result(0, "", list);
	}

	@RequestMapping("/establish")
	@ResponseBody
	public Result establishSector(String sectorName) {
		int i = sectorService.establishSector(sectorName);
		if (i != 0)
			return new Result(0, "创建成功", i);
		else
			return new Result(0, "创建失败", i);
	}
}
