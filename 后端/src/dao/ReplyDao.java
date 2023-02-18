package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import pojo.ReplyInfo;

@Repository("replyDao")
@Mapper
public interface ReplyDao {
	// �ظ�����
	public int addReply(ReplyInfo reply);

	// �鿴��Ӧ���ӵ����лظ�
	public List<ReplyInfo> selectAllReply(Integer TopicId);

	// ɾ������ʱɾ����Ӧ��
	public int deleteAllReply(Integer topicId);

	// ɾ��ģ��ʱɾ�����еĻظ�
	public int deleteSectorReply(String sectorName);

	// ɾ���ظ�
	public int deleteReply(Integer replyId);
	
	//����
	public int upClicking(Integer replyId);
}
