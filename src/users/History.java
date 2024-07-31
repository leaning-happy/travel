package users;

import java.util.Date;

public class History {
	private String slight; //景点名称
	private String account; //浏览用户的账号
	private Date time; //浏览的时间
	public String getSlight() {
		return slight;
	}
	public void setSlight(String slight) {
		this.slight = slight;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	

}
