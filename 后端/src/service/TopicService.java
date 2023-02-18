package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TopicDao;
import pojo.TopicInfo;

@Service
public class TopicService {
	@Autowired
	private TopicDao topicDao;

	public List<TopicInfo> listTopic(Integer AccountId) {
		return topicDao.selectPersonalTopic(AccountId);
	}

	public List<TopicInfo> allListTopic() {
		return topicDao.selectAllTopic();
	}

	public int addTopic(TopicInfo topicInfo) {
		return topicDao.addTopic(topicInfo);
	}

	public List<TopicInfo> selectSectorTopic(Integer sectorId) {
		return topicDao.selectTopic(sectorId);
	}

	public int updateReplyNumber(Integer topicId) {
		return topicDao.updateReplyNumber(topicId);
	}

	public int updateClickingRateNumber(Integer topicId) {
		return topicDao.updateClickingRateNumber(topicId);
	}

	public int deleteTopic(Integer topicId) {
		return topicDao.deleteTopic(topicId);
	}

	public int deleteAlltopic(String sectorName) {
		return topicDao.deleteAllTopic(sectorName);
	}

	public int topicNumber() {
		return topicDao.topicNumber();
	}
	
	public List<TopicInfo> checkTopic(String topicName){
		return topicDao.checkTopic(topicName);
	}
	
	public int downTopic(Integer topicId) {
		return topicDao.downTopic(topicId);
	}
}
