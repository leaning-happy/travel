package users;

import java.util.Date;

public class Chat {
	//发送日期
	private Date sendDate;
	//发送人
	private String account;
	//发送端
	private boolean type;
	//交流的唯一标识符号
	private String chatId;
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	

}
