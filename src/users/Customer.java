package users;

public class Customer {
	
	//�û��˺�
	private String account;
	//����
	private String password;
	//����
	private String name;
	//�ʼ�
	private String mail;
	//�ֻ�����
	private String phonenumber;
	//�Ա�
	private String sex;
	//����
	private String type;
	//����
	private String age;
	//���˼��
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
		// TODO �Զ����ɵķ������
		this.write = write;
	}

}
