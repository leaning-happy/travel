package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import jdbc.JDBCKit;
import users.History;
import users.Scenery;

public class SceneryDao {
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private String sql="";
//����������Ϊ��Ӧ��ǩ
	public List<String> getTType(int type){
		List<String> list=new ArrayList<String>();
		Integer x=String.valueOf(type).length();
		List<Integer> y= new ArrayList<Integer>();
		String a="ɽ������";
		String b="ɭ�־���";
		String c="��������";
		String d="��������";
		String e="���о���";
		String f="�ڽ�������";
		String g="����������";
		String h="��ʷ���ﾰ��";
		String i="�����Ļ�����";	
		for(;x>=1;) {
			Integer ha=(int) (type/(Math.pow(10,x-1)));
			y.add(ha);
			type=(int) (type-ha*Math.pow(10,x-1));
			x--;
		}
		for(int ty=0;ty<y.size();ty++) {
		Integer typ=y.get(ty);
		switch (typ) {
		case 1:
			list.add(a);
			break;
		case 2:
			list.add(b);
			break;
		case 3:
			list.add(c);
			break;
		case 4:
			list.add(d);
			break;
		case 5:
			list.add(e);
			break;
		case 6:
			list.add(f);
			break;
		case 7:
			list.add(g);
			break;
		case 8:
			list.add(h);
			break;
		case 9:
			list.add(i);
			break;
		}
		} 
		return list;
	}
    public String getbelong(String a) {
        Integer b=Integer.valueOf(a);
        String c = null;
        switch(b) {
        case 1:c="����ʡ";break;
        case 2:c="������";break;
        case 3:c="�����";break;
        case 4:c="�㽭ʡ";break;
        case 5:c="������";break;
        case 6:c="����ʡ";break;
        case 7:c="����ʡ";break;
        case 8:c="�㶫ʡ";break;
        case 9:c="����ʡ";break;
        case 10:c="����ʡ";break;
        case 11:c="ɽ��ʡ";break;
        case 12:c="����ʡ";break;
        case 13:c="������ʡ";break;
        case 14:c="����ʡ";break;
        case 15:c="����ʡ";break;
        case 16:c="����ʡ";break;
        case 17:c="�Ĵ�ʡ";break;
        case 18:c="�ຣʡ";break;
        case 19:c="����ʡ";break;
        case 20:c="����ʡ";break;
        case 21:c="����ʡ";break;
        case 22:c="̨��ʡ";break;
        case 23:c="����ʡ";break;
        case 24:c="�Ϻ���";break;
        case 25:c="����ʡ";break;
        case 26:c="ɽ��ʡ";break;
        case 27:c="�ӱ�ʡ";break;
        case 28:c="�����ر�������";break;
        case 29:c="����ر�������";break;
        case 30:c="����׳��������";break;
        case 31:c="���ز���������";break;
        case 32:c="�½�ά�����������";break;
        case 33:c="���Ļ���������";break;
        case 34:c="���ɹ�������";break; 	
        }
    	return c;
    }
//ͨ��ɸѡ������ȡ������Ϣ
	public List<Scenery> getinformationx(String case1,String case2) throws SQLException{
		conn=JDBCKit.getConnection();
		List<Scenery> list=new ArrayList<Scenery>();
		if(case1.equals("0")) {
			sql="select * from scenery where type like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+case2+"%");
		}
		else if(case2.equals("0")) {
			sql="select * from scenery where belong like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,getbelong(case1)+"%");
		}
		else {
			sql="select * from scenery where belong like ? and type like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,getbelong(case1)+"%");
			ps.setString(2,"%"+case2+"%");
		}
		rs=ps.executeQuery();
		try {
		while(rs.next()){
			Scenery reform=new Scenery();
			reform.setBelongcity(rs.getString("belong"));
			reform.setName(rs.getString("name"));
			reform.setBrief(rs.getString("brief"));
			reform.setImgpath(rs.getString("img"));
			reform.setType(getTType(rs.getInt("type")));
			reform.setVisittimes(rs.getInt("visittimes"));
			list.add(reform);
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		conn.close();
		rs.close();
		ps.close();
		return list;
    }
//ͨ��ģ��������ȡ������Ϣ
	public List<Scenery> getinformationy(String case1) throws SQLException{
		conn=JDBCKit.getConnection();
		List<Scenery> list=new ArrayList<Scenery>();
		sql="select * from scenery where name like ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1,"%"+case1+"%");
		rs=ps.executeQuery();
		try {
		while(rs.next()){
			Scenery reform=new Scenery();
			reform.setBelongcity(rs.getString("belong"));
			reform.setName(rs.getString("name"));
			reform.setBrief(rs.getString("brief"));
			reform.setImgpath(rs.getString("img"));
			reform.setType(getTType(rs.getInt("type")));
			reform.setVisittimes(rs.getInt("visittimes"));
			list.add(reform);
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		conn.close();
		rs.close();
		ps.close();
		return list;
	}
//��ȷ����
	public int getinformationd(String case1) throws SQLException{
		conn=JDBCKit.getConnection();
		sql="select * from scenery where name=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1,case1);
		rs=ps.executeQuery();
		int x=0;
		try {
		while(rs.next()){
			x=rs.getInt("type");
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		conn.close();
		rs.close();
		ps.close();
		return x;
	}
//��ҳͨ���ص㶨λ��ȡ
	public List<Scenery> getinformationb(String case1) throws SQLException{
		conn=JDBCKit.getConnection();
		List<Scenery> list=new ArrayList<Scenery>();
		sql="select * from scenery where belong like ? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1,case1+"%");
		rs=ps.executeQuery();
		try {
		while(rs.next()){
			Scenery reform=new Scenery();
			reform.setBelongcity(rs.getString("belong"));
			reform.setName(rs.getString("name"));
			reform.setBrief(rs.getString("brief"));
			reform.setImgpath(rs.getString("img"));
			reform.setType(getTType(rs.getInt("type")));
			reform.setVisittimes(rs.getInt("visittimes"));
			list.add(reform);
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		conn.close();
		rs.close();
		ps.close();
		return list;
	}
//��Ӿ�����Ϣ
	public boolean addscenery(String name,String belongcity,String imagepath,String brief,int type) {
		conn=JDBCKit.getConnection();
		boolean flag=false;
		sql="insert into scenery(name, belong,image,brief,type) values (?,?,?,?,?)";
		int result = -1;// ��ʾ���û�ִ�����ɾ�����޸ĵ�ʱ����Ӱ�����ݿ������
		try {
			ps = conn.prepareStatement(sql);
			if(name == null) {
				return false;
			}
			ps.setString(1, name);
			ps.setString(2, belongcity);
			ps.setString(3, imagepath);
			ps.setString(4, brief);
			ps.setLong(5, type);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		flag = result > 0 ? true : false;
		return flag;			
	}
	//��ȡ��ʷ����з���
	public List<Scenery> getlikescenery(String account) throws SQLException{
		HistoryDao historyDao=new HistoryDao();
		List<History> list=new ArrayList<History>();
		list=historyDao.gethistory(account);
		if(list.size()==0) {
			return null;
		}else {
		String  type="";
		for(int i = 0 ; i < list.size() ; i++) {
			type=type+getinformationd(list.get(i).getSlight());
		}
		int a=0,b=0,c=0,d=0,e=0,f=0,h=0,j=0,k=0;
		for (int i = 0, len = type.length(); i < len; i++) {                
			char y = type.charAt(i);                
			if (y == '1' ) {a++;} 
			if (y == '2' ) {b++;}
			if (y == '3' ) {c++;} 
			if (y == '4' ) {d++;} 
			if (y == '5' ) {e++;} 
			if (y == '6' ) {f++;} 
			if (y == '7' ) {h++;} 
			if (y == '8' ) {j++;} 
			if (y == '9' ) {k++;} }
		int num[]= {a,b,c,d,e,f,h,j,k};
		for (int i=0 ;i<8;i++)
		if(num[i]>=num[i+1]) {
			num[i+1]=num[i];
		}
		String end=""+num[8];
		List<Scenery> listl=new ArrayList<Scenery>();
		listl=getinformationx("0", end);
		return listl;
	}}
	//��ҳ��ȡ������������
	public List<Scenery> getinformationz() throws SQLException{
		conn=JDBCKit.getConnection();
		List<Scenery> list=new ArrayList<Scenery>();
		sql="select slight,count(*) as num from history group by slight order by num desc ";
		ps = conn.prepareStatement(sql);
		rs=ps.executeQuery();
		try {
		while(rs.next()){
			Scenery reform=new Scenery();
			reform.setName(rs.getString("slight"));
			list.add(reform);
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		conn.close();
		rs.close();
		ps.close();
		return list;
	}
}
