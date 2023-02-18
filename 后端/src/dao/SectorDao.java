package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import pojo.SectorInfo;

@Repository("sectorDao")
@Mapper
public interface SectorDao {
	// 版主查看自己所管理的板块
	public List<SectorInfo> checkSector(Integer AccountId);

	// 发帖时数量+1
	public int updateTopicNumber(Integer SectorId);

	// 用户查看所有的模板
	public List<SectorInfo> checkAllSector();

	// 用户进入模板时 点击数+1
	public int updateClickingRateNumber(Integer SectorId);

	// 超级管理员删除不合规的板块
	public int deleteSector(String sectorName);

	// 添加模块
	public int addSector(SectorInfo sector);

	// 取消版主权限同时 板块归管理员
	public int downSector(String accountId);

	// 获得板块名
	public List<String> checkName();

	// 创建板块
	public int establishSector(String sectorName);
}
