package users;

import java.util.Date;

public class Chat {
	//��������
	private Date sendDate;
	//������
	private String account;
	//���Ͷ�
	private boolean type;
	//������Ψһ��ʶ����
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
