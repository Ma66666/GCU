package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SectorDao;
import pojo.SectorInfo;

@Service
public class SectorService {
	@Autowired
	private SectorDao sectorDao;

	public List<SectorInfo> checkSector(Integer accountId) {
		return sectorDao.checkSector(accountId);
	}

	public int updateTopicNumber(Integer sectorId) {
		return sectorDao.updateTopicNumber(sectorId);
	}

	public List<SectorInfo> checkAllSector() {
		return sectorDao.checkAllSector();
	}

	public int updateClickingRateNumber(Integer sectorId) {
		return sectorDao.updateClickingRateNumber(sectorId);
	}

	public int deleteSector(String sectorName) {
		return sectorDao.deleteSector(sectorName);
	}

	public int addSector(SectorInfo sector) {
		return sectorDao.addSector(sector);
	}

	public int downSector(String accountId) {
		return sectorDao.downSector(accountId);
	}

	public List<String> checkName() {
		return sectorDao.checkName();
	}

	public int establishSector(String sectorName) {
		return sectorDao.establishSector(sectorName);
	}
}
