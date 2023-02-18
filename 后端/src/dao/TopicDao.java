package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import pojo.TopicInfo;

@Repository("topicDao")
@Mapper
public interface TopicDao {
	// 查询个人发的帖子
	public List<TopicInfo> selectPersonalTopic(Integer AccountId);

	// 查看所有的帖子
	public List<TopicInfo> selectAllTopic();

	// 发布帖子
	public int addTopic(TopicInfo topicInfo);

	// 查看对应模板的所有帖子
	public List<TopicInfo> selectTopic(Integer sectorId);

	// 回复帖子时 数量+1
	public int updateReplyNumber(Integer topicId);

	// 查看对应帖子时 点击数+1
	public int updateClickingRateNumber(Integer topicId);

	// 版主删除不合规的帖子
	public int deleteTopic(Integer topicId);

	// 超级管理员删除板块时删除相关联的帖子 因为外键不能自增所以只能写这个了
	public int deleteAllTopic(String sectorName);

	// 返回帖子数
	public int topicNumber();
	
	//模糊查询
	public List<TopicInfo> checkTopic(String topicName);
	
	//删贴时 对应模块帖子数-1
	public int downTopic(Integer topicId);
}
