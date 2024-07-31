package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCKit;
import users.Team;

public class TeamDao {
	
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private String sql="";
//创建组队
	public void create(Team team,String account) throws SQLException {
		// TODO 自动生成的方法存根
		conn=JDBCKit.getConnection();
		sql="insert into team(startcon, startdetialcon,teamholder,maxnum,starttime,endcon,enddetialcon) values (?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setString(1, team.getStart());
		ps.setString(2, team.getStartdetial());
		ps.setString(3, team.getTeamholder());
		ps.setInt(4, team.getMaxnum());
		ps.setString(5, team.getTime());
		ps.setString(6, team.getEnd());
		ps.setString(7, team.getEnddetial());
		ps.executeUpdate();
		rs = ps.getGeneratedKeys();
		if(rs.next()){
			int userSpaceID = rs.getInt(1);
		    sql="insert into teamdetial(teamid,account) values(?,?)";
		    ps=conn.prepareStatement(sql);
		    ps.setInt(1, userSpaceID);
		    ps.setString(2, account);
		    ps.executeUpdate();
		}
	}
//获取个人的组队
	public List<Team> getteam(String account) throws SQLException {
		// TODO 自动生成的方法存根
		conn=JDBCKit.getConnection();
		sql="select * from team left join teamdetial on team.id=teamdetial.teamid where teamdetial.account=?";
		String sqll = "select count(teamid) as num from teamdetial where teamid=?";
		ps = conn.prepareStatement(sql);
		List<Team> list=new ArrayList<Team>();
		ps.setString(1, account);
		rs=ps.executeQuery();
		while(rs.next()) {
			Team team=new Team();
			team.setEnd(rs.getString("endcon"));
			team.setEnddetial(rs.getString("enddetialcon"));
			team.setId(rs.getInt("id"));
			team.setMaxnum(rs.getInt("maxnum"));
			team.setStart(rs.getString("startcon"));
			team.setStartdetial(rs.getString("startdetialcon"));
			team.setTeamholder(rs.getString("teamholder"));
			team.setTime(rs.getString("starttime"));
			PreparedStatement psh = conn.prepareStatement(sqll);
			psh.setInt(1, rs.getInt("id"));
			ResultSet res = psh.executeQuery();
			while(res.next()) {
			System.out.println(res.getInt("num"));
			team.setNum(res.getInt("num"));}
			list.add(team);
		}
		conn.close();
		rs.close();
		ps.close();
		return list;
	}
//搜寻组队
	public List<Team> checkTeams(String type,String h) throws SQLException {
		conn=JDBCKit.getConnection();
		List<Team> list=new ArrayList<Team>();
		switch(type) {	
		case "1":
			sql="select * from team where id=?";
			int ide=Integer.parseInt(h);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ide);break;
		/*case "2":
			sql="select * from team where startcon=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+h+"%");break;*/
		case "2":
			sql="select * from team where endcon like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+h+"%");break;
		case "0":
			sql="select * from team where teamholder like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+h+"%");break;
		}
		String sqll = "select count(teamid) as num from teamdetial where teamid=?";
		rs=ps.executeQuery();
		if(rs.next()) {
			Team team=new Team();
			team.setEnd(rs.getString("endcon"));
			team.setEnddetial(rs.getString("enddetialcon"));
			team.setId(rs.getInt("id"));
			team.setMaxnum(rs.getInt("maxnum"));
			team.setStart(rs.getString("startcon"));
			team.setStartdetial(rs.getString("startdetialcon"));
			team.setTeamholder(rs.getString("teamholder"));
			team.setTime(rs.getString("starttime"));
			PreparedStatement psh = conn.prepareStatement(sqll);
			psh.setInt(1, rs.getInt("id"));
			ResultSet res = psh.executeQuery();
			while(res.next()) {
			
			team.setNum(res.getInt("num"));}
			list.add(team);
		}
		
		return list;
		
	}
	public void deleteteam(String h, String account) throws SQLException {
		// TODO 自动生成的方法存根
		int ide=Integer.parseInt(h);
		conn=JDBCKit.getConnection();
		sql="delete  from teamdetial where teamid=? and account=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, ide);
		ps.setString(2, account);
		ps.executeUpdate();
	}
	public void addteam(String h, String account) throws SQLException {
		// TODO 自动生成的方法存根
		int ide=Integer.parseInt(h);
		conn=JDBCKit.getConnection();
		sql="insert into teamdetial(teamid,account) values(?,?) ";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, ide);
		ps.setString(2, account);
		ps.executeUpdate();
	}
}
