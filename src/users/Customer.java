package users;

public class Customer {
	
	//用户账号
	private String account;
	//密码
	private String password;
	//姓名
	private String name;
	//邮件
	private String mail;
	//手机号码
	private String phonenumber;
	//性别
	private String sex;
	//种类
	private String type;
	//年龄
	private String age;
	//个人简介
	private String write;
	public String getWrite() {
		return write;
	}
	public Customer() {
		
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setWrite(String write) {
		// TODO 自动生成的方法存根
		this.write = write;
	}

}
