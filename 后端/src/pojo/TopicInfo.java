package pojo;

public class TopicInfo {

	int TopicId;
	String AccountName;
	String AccountId;
	String Title;
	String TopicText;
	String TopicDate;
	int ReplyCount;
	int ClickingRate;
	String SectorName;
	int SectorId;
	String TopicPicture;
	String AccountPicture;
	String ReplyPicture;

	public TopicInfo(String Title, String TopicText, String TopicDate, int ReplyCount, int ClickingRate,
			String SectorName) {
		this.Title = Title;
		this.TopicText = TopicText;
		this.TopicDate = TopicDate;
		this.ReplyCount = ReplyCount;
		this.ClickingRate = ClickingRate;
		this.SectorName = SectorName;
	}

	public TopicInfo() {

	}

	public String getReplyPicture() {
		return ReplyPicture;
	}

	public void setReplyPicture(String replyPicture) {
		ReplyPicture = replyPicture;
	}

	public String getAccountPicture() {
		return AccountPicture;
	}

	public void setAccountPicture(String accountPicture) {
		AccountPicture = accountPicture;
	}

	public String getTopicPicture() {
		return TopicPicture;
	}

	public void setTopicPicture(String topicPicture) {
		TopicPicture = topicPicture;
	}

	public int getTopicId() {
		return TopicId;
	}

	public void setTopicId(int topicId) {
		TopicId = topicId;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAccountId() {
		return AccountId;
	}

	public void setAccountId(String AccountId) {
		this.AccountId = AccountId;
	}

	public int getSectorId() {
		return SectorId;
	}

	public void setSectorId(int sectorId) {
		SectorId = sectorId;
	}

	public String getTopicText() {
		return TopicText;
	}

	public void setTopicText(String topicText) {
		TopicText = topicText;
	}

	public String getTopicDate() {
		return TopicDate;
	}

	public void setTopicDate(String topicDate) {
		TopicDate = topicDate;
	}

	public int getReplyCount() {
		return ReplyCount;
	}

	public void setReplyCount(int replyCount) {
		ReplyCount = replyCount;
	}

	public int getClickingRate() {
		return ClickingRate;
	}

	public void setClickingRate(int clickingRate) {
		ClickingRate = clickingRate;
	}

	public String getSectorName() {
		return SectorName;
	}

	public void setSectorName(String sectorName) {
		SectorName = sectorName;
	}

}
