package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import pojo.TopicInfo;

@Repository("topicDao")
@Mapper
public interface TopicDao {
	// ��ѯ���˷�������
	public List<TopicInfo> selectPersonalTopic(Integer AccountId);

	// �鿴���е�����
	public List<TopicInfo> selectAllTopic();

	// ��������
	public int addTopic(TopicInfo topicInfo);

	// �鿴��Ӧģ�����������
	public List<TopicInfo> selectTopic(Integer sectorId);

	// �ظ�����ʱ ����+1
	public int updateReplyNumber(Integer topicId);

	// �鿴��Ӧ����ʱ �����+1
	public int updateClickingRateNumber(Integer topicId);

	// ����ɾ�����Ϲ������
	public int deleteTopic(Integer topicId);

	// ��������Աɾ�����ʱɾ������������� ��Ϊ���������������ֻ��д�����
	public int deleteAllTopic(String sectorName);

	// ����������
	public int topicNumber();
	
	//ģ����ѯ
	public List<TopicInfo> checkTopic(String topicName);
	
	//ɾ��ʱ ��Ӧģ��������-1
	public int downTopic(Integer topicId);
}
