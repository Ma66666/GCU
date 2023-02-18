package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import pojo.ReplyInfo;

@Repository("replyDao")
@Mapper
public interface ReplyDao {
	// 回复帖子
	public int addReply(ReplyInfo reply);

	// 查看对应帖子的所有回复
	public List<ReplyInfo> selectAllReply(Integer TopicId);

	// 删除帖子时删除对应的
	public int deleteAllReply(Integer topicId);

	// 删除模板时删除其中的回复
	public int deleteSectorReply(String sectorName);

	// 删除回复
	public int deleteReply(Integer replyId);
	
	//点赞
	public int upClicking(Integer replyId);
}
