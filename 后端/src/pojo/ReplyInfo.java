package pojo;

public class ReplyInfo {

	int ReplyId;
	int TopicId;
	String AccountName;
	String AccountId;
	String ReplyText;
	String ReplyDate;
	int ClickingRate;
	String AccountPicture;
	String ReplyPicture;

	public ReplyInfo() {

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

	public int getReplyId() {
		return ReplyId;
	}

	public void setReplyId(int replyId) {
		ReplyId = replyId;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public int getTopicId() {
		return TopicId;
	}

	public void setTopicId(int topicId) {
		TopicId = topicId;
	}

	public String getAccountId() {
		return AccountId;
	}

	public void setAccountId(String accountId) {
		AccountId = accountId;
	}

	public String getReplyText() {
		return ReplyText;
	}

	public void setReplyText(String replyText) {
		ReplyText = replyText;
	}

	public String getReplyDate() {
		return ReplyDate;
	}

	public void setReplyDate(String replyDate) {
		ReplyDate = replyDate;
	}

	public int getClickingRate() {
		return ClickingRate;
	}

	public void setClickingRate(int clickingRate) {
		ClickingRate = clickingRate;
	}

}
