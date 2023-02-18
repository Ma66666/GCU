package pojo;

public class SectorInfo {
	int SectorId;
	String AccountId;
	String SectorName;
	int ClickingRate;
	int TopicCount;
	String AccountName;

	public SectorInfo() {

	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public int getSectorId() {
		return SectorId;
	}

	public void setSectorId(int sectorId) {
		SectorId = sectorId;
	}

	public String getAccountId() {
		return AccountId;
	}

	public void setAccountId(String accountId) {
		AccountId = accountId;
	}

	public String getSectorName() {
		return SectorName;
	}

	public void setSectorName(String sectorName) {
		SectorName = sectorName;
	}

	public int getClickingRate() {
		return ClickingRate;
	}

	public void setClickingRate(int clickingRate) {
		ClickingRate = clickingRate;
	}

	public int getTopicCount() {
		return TopicCount;
	}

	public void setTopicCount(int topicCount) {
		TopicCount = topicCount;
	}
	
}
