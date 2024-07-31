package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JDBCKit;
import users.Customer;

public class UserDao {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private String sql="";
//�û���¼
	public boolean login(Customer user) throws SQLException {	
		boolean returnValue = false;
		conn = JDBCKit.getConnection();
		sql="select * from user where account=? and password=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1,user.getAccount());
		ps.setString(2,user.getPassword());
		rs=ps.executeQuery();
		if(rs.next()){
			returnValue=true;
			rs.close();
			ps.close();
		}else{
			returnValue=false;
			rs.close();
			ps.close();
		}
		conn.close();
		return returnValue;
	}
//��ȡ�û�����
	public String readname(String acount) throws SQLException  {
		conn = JDBCKit.getConnection();
		sql="select name from user where account=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1,acount);
		rs=ps.executeQuery();
		String a=" ";
		if(rs.next()) {
			a=rs.getString("name");
			rs.close();
			ps.close();
			}
		return a;
	}
//�����û�����
	public void changePW(String account,String password) throws SQLException {
		conn = JDBCKit.getConnection();
		sql="update user set password = ? where account=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, password);
		ps.setString(2, account);
		ps.executeUpdate();
	}
//�����û�����
	public void changeMail(String account,String mail) throws SQLException {
		conn = JDBCKit.getConnection();
		sql="update user set mail = ? where account=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, mail);
		ps.setString(2, account);
		ps.executeUpdate();
	}
	//�����û��ֻ�����
		public void changePhone(String account,String mail) throws SQLException {
			conn = JDBCKit.getConnection();
			sql="update user set phonenumber = ? where account=?";
			ps = conn.prepareStatement(sql);
//			String star=type.replace("\'","").replace("\'","");
			ps.setString(1, mail);
			ps.setString(2, account);
			ps.executeUpdate();
		}
//��ȡ������Ϣ�����ڸ��ĸ�����Ϣʱ��չʾ��
	public Customer Dsql(String account) throws SQLException  {
//		List<Customer> reforms=new ArrayList<Customer>();
		conn = JDBCKit.getConnection();
		sql="select * from user where account=?"; 
		ps = conn.prepareStatement(sql);
		ps.setString(1,account);
		rs=ps.executeQuery();
		Customer reform=new Customer();
		try {
		while(rs.next()){
			reform.setAccount(account);
			reform.setName(rs.getString("name"));
			reform.setSex(rs.getString("sex"));
			reform.setAge(rs.getString("age"));
			System.out.println(rs.getString("age"));
			reform.setPassword(rs.getString("password"));
			reform.setMail(rs.getString("mail"));
			reform.setPhonenumber(rs.getString("phonenumber"));
			reform.setType(rs.getString("type"));
			reform.setWrite(rs.getString("writebrief"));
			}
		return reform;
	} catch (Exception e)
	{
		// TODO: handle exception
		e.printStackTrace();
		JDBCKit.release(rs, null, conn);
		return null;
	}
}
//��������������ϢOI=otherinformation	
	public void changeOI(String account,String name,String sex,String age, String write) throws SQLException {
		conn = JDBCKit.getConnection();
		sql="update user set name=?,sex=?,age=?,writebrief=? where account=?";
		ps = conn.prepareStatement(sql);
//		String str=type.replace("\'","").replace("\'","");
//		ps.setString(1,str);
		ps.setString(1, name);
		ps.setString(2, sex);
		ps.setString(3, age);
		ps.setString(4, write);
		ps.setString(5, account);
		ps.executeUpdate();
	}
//�û�ע��
	public boolean reg(Customer user) throws SQLException{
		boolean flag=false;
		conn=JDBCKit.getConnection();
		sql="insert into user(account, password,sex,name,mail,phonenumber,age,type,writebrief) values (?, ?,?,?,?,?,?,?,?)";		
		int result = -1;// ��ʾ���û�ִ�����ɾ�����޸ĵ�ʱ����Ӱ�����ݿ������
		try {
			ps = conn.prepareStatement(sql);
			if(user == null) {
				return false;
			}
			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getName());
			ps.setString(5, user.getMail());
			ps.setString(6, user.getPhonenumber());
			ps.setString(7, user.getAge());
			ps.setString(8, "customer");
			ps.setString(9, "��Һ�");
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		flag = result > 0 ? true : false;
		return flag;			
	}
	//����Աע�����Ա�˺�
		public boolean regad(Customer user) throws SQLException{
			boolean flag=false;
			conn=JDBCKit.getConnection();
			sql="insert into user(account, password��type) values (?, ?,?)";		
			int result = -1;// ��ʾ���û�ִ�����ɾ�����޸ĵ�ʱ����Ӱ�����ݿ������
			try {
				ps = conn.prepareStatement(sql);
				if(user == null) {
					return false;
				}
				ps.setString(1, user.getAccount());
				ps.setString(2, user.getPassword());
				ps.setString(3, "admin");
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			flag = result > 0 ? true : false;
			return flag;			
		}
		

//�ж��û��������ݿ����Ƿ����
 
    public boolean userIsExist(String username) throws SQLException{
        // ��ȡ���ݿ�����Connection����
        conn = JDBCKit.getConnection();
        // ����ָ���û�����ѯ�û���Ϣ
        sql = "select * from user where account = ?";
        try {
            // ��ȡPreparedStatement����
            ps = conn.prepareStatement(sql);
            // ���û��������Ը�ֵ
            ps.setString(1, username);
            // ִ�в�ѯ��ȡ�����
            rs = ps.executeQuery();
            // �жϽ�����Ƿ���Ч
            if(!rs.next()){
               System.out.println(1);
                // �����Ч��֤�����û�������
                return true;
            }
            System.out.println(2);
            // �ͷŴ� ResultSet ��������ݿ�� JDBC ��Դ
            rs.close();
            // �ͷŴ� PreparedStatement ��������ݿ�� JDBC ��Դ
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // �ر����ݿ�����
            conn.close();
        }
        return false;
    }
}
