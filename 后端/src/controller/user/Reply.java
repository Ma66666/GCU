package controller.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ReplyInfo;
import pojo.Result;
import pojo.TopicInfo;
import service.ReplyService;
import service.TopicService;

@Controller
@RequestMapping("/reply")
public class Reply {

	@Autowired
	private ReplyService replyService;
	@Autowired
	private TopicService topicService;

	@RequestMapping("/add")
	@ResponseBody
	public Result addReply(ReplyInfo replyInfo) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		Date date = new Date(); // ��ȡ��ǰʱ��
		String str = format.format(date);
		replyInfo.setReplyDate(str);
		try {
			int rt = replyService.addReply(replyInfo);
		} catch (NullPointerException e) {
			return new Result(0, "����δ��д����", 0);
		} catch (Exception e) {
			return new Result(0, "ȱ�ٲ���", 0);
		}
		int i = topicService.updateReplyNumber(replyInfo.getTopicId());
		return new Result(0, "�����ɹ�", 1);
	}

	@RequestMapping("/list")
	@ResponseBody
	public Result listUser(Integer topicId) {
		List<ReplyInfo> infos = replyService.listReply(topicId);
		int i = topicService.updateClickingRateNumber(topicId);
		return new Result(0, "", infos);

	}

	@RequestMapping("/delete")
	@ResponseBody
	public Result deleteReply(Integer replyId) {
		int i = replyService.deleteReply(replyId);
		if (i != 0)
			return new Result(0, "ɾ���ɹ�", 1);
		else
			return new Result(0, "ɾ��ʧ��", 0);
	}
	
	@RequestMapping("/up")
	@ResponseBody
	public Result upClicking(Integer replyId) {
		int i = replyService.upClicking(replyId);
		if (i != 0)
			return new Result(0, "���޳ɹ�", 1);
		else
			return new Result(0, "����ʧ��", 0);
	}
}
