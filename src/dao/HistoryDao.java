package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCKit;
import users.History;

public class HistoryDao {
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private String sql="";
	//��ȡ�����ʷ
	public List<History> gethistory(String account) throws SQLException{
		conn=JDBCKit.getConnection();
		List<History> list=new ArrayList<History>();
		sql="select * from history where account=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, account);
		rs=ps.executeQuery();
		while(rs.next()) {
			History a=new History();
			a.setAccount(rs.getString("account"));
			a.setSlight(rs.getString("slight"));
			a.setTime(rs.getDate("time"));
			list.add(a);
		}
		return list;
		
	}
	//��ȡ��ʷ����з���
	//��������ʷ
	public boolean addhistory(String name,String account) {
		conn=JDBCKit.getConnection();
		boolean flag=false;
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql="insert into history(slight, account,time) values (?,?,?)";
		int result = -1;// ��ʾ���û�ִ�����ɾ�����޸ĵ�ʱ����Ӱ�����ݿ������
		try {
			ps = conn.prepareStatement(sql);
			if(name == null) {
				return false;
			}
			ps.setString(1, name);
			ps.setString(2, account);
			ps.setDate(3,new java.sql.Date(System.currentTimeMillis())); 
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		flag = result > 0 ? true : false;
		return flag;			
	}

}
