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
//用户登录
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
//读取用户姓名
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
//更新用户密码
	public void changePW(String account,String password) throws SQLException {
		conn = JDBCKit.getConnection();
		sql="update user set password = ? where account=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, password);
		ps.setString(2, account);
		ps.executeUpdate();
	}
//更新用户邮箱
	public void changeMail(String account,String mail) throws SQLException {
		conn = JDBCKit.getConnection();
		sql="update user set mail = ? where account=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, mail);
		ps.setString(2, account);
		ps.executeUpdate();
	}
	//更新用户手机号码
		public void changePhone(String account,String mail) throws SQLException {
			conn = JDBCKit.getConnection();
			sql="update user set phonenumber = ? where account=?";
			ps = conn.prepareStatement(sql);
//			String star=type.replace("\'","").replace("\'","");
			ps.setString(1, mail);
			ps.setString(2, account);
			ps.executeUpdate();
		}
//获取其他信息（用于更改个人信息时的展示）
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
//更新其他个人信息OI=otherinformation	
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
//用户注册
	public boolean reg(Customer user) throws SQLException{
		boolean flag=false;
		conn=JDBCKit.getConnection();
		sql="insert into user(account, password,sex,name,mail,phonenumber,age,type,writebrief) values (?, ?,?,?,?,?,?,?,?)";		
		int result = -1;// 表示当用户执行添加删除和修改的时候所影响数据库的行数
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
			ps.setString(9, "大家好");
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		flag = result > 0 ? true : false;
		return flag;			
	}
	//管理员注册管理员账号
		public boolean regad(Customer user) throws SQLException{
			boolean flag=false;
			conn=JDBCKit.getConnection();
			sql="insert into user(account, password，type) values (?, ?,?)";		
			int result = -1;// 表示当用户执行添加删除和修改的时候所影响数据库的行数
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
		

//判断用户名在数据库中是否存在
 
    public boolean userIsExist(String username) throws SQLException{
        // 获取数据库连接Connection对象
        conn = JDBCKit.getConnection();
        // 根据指定用户名查询用户信息
        sql = "select * from user where account = ?";
        try {
            // 获取PreparedStatement对象
            ps = conn.prepareStatement(sql);
            // 对用户对象属性赋值
            ps.setString(1, username);
            // 执行查询获取结果集
            rs = ps.executeQuery();
            // 判断结果集是否有效
            if(!rs.next()){
               System.out.println(1);
                // 如果无效则证明此用户名可用
                return true;
            }
            System.out.println(2);
            // 释放此 ResultSet 对象的数据库和 JDBC 资源
            rs.close();
            // 释放此 PreparedStatement 对象的数据库和 JDBC 资源
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            conn.close();
        }
        return false;
    }
}
