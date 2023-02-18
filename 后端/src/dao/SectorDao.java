package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import pojo.SectorInfo;

@Repository("sectorDao")
@Mapper
public interface SectorDao {
	// �����鿴�Լ�������İ��
	public List<SectorInfo> checkSector(Integer AccountId);

	// ����ʱ����+1
	public int updateTopicNumber(Integer SectorId);

	// �û��鿴���е�ģ��
	public List<SectorInfo> checkAllSector();

	// �û�����ģ��ʱ �����+1
	public int updateClickingRateNumber(Integer SectorId);

	// ��������Աɾ�����Ϲ�İ��
	public int deleteSector(String sectorName);

	// ���ģ��
	public int addSector(SectorInfo sector);

	// ȡ������Ȩ��ͬʱ �������Ա
	public int downSector(String accountId);

	// ��ð����
	public List<String> checkName();

	// �������
	public int establishSector(String sectorName);
}
