package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReplyDao;
import pojo.ReplyInfo;

@Service
public class ReplyService {
	@Autowired
	private ReplyDao replyDao;

	public int addReply(ReplyInfo reply) {
		int i = replyDao.addReply(reply);
		return i;
	}

	public List<ReplyInfo> listReply(Integer TopicId) {

		return replyDao.selectAllReply(TopicId);
	}

	public int deleteAllReply(Integer topicId) {
		return replyDao.deleteAllReply(topicId);
	}

	public int deleteSectorReply(String sectorName) {
		return replyDao.deleteSectorReply(sectorName);
	}
	
	public int deleteReply(Integer replyId) {
		return replyDao.deleteReply(replyId);
	}
	
	public int upClicking(Integer replyId) {
		return replyDao.upClicking(replyId);
	}
}
