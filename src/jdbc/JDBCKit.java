package jdbc;

//import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Properties;

public class JDBCKit {

	    // �������������ݿ�url
	    private static String url = null;
	    private static String driverClass = null;
	    // ���ݿ��û���������
	    private static String userName = null;
	    private static String password = null;

	    /**
	     * ��ʼ����������
	     * ��̬������У�ֻ����һ�Σ�
	     */
	    static{
//	        try {
	            //��ȡdb.properties�ļ�
	            //Properties prop = new Properties();

	            /**
	             * ʹ����·���Ķ�ȡ��ʽ
	             *  / : б�ܱ�ʾclasspath�ĸ�Ŀ¼
	             *     ��java��Ŀ�£�classpath�ĸ�Ŀ¼��binĿ¼��ʼ
	             *     ��web��Ŀ�£�classpath�ĸ�Ŀ¼��WEB-INF/classesĿ¼��ʼ
	             */
	            //InputStream in = JDBCKit.class.getResourceAsStream("/db.properties");

	            //�����ļ�
	           // prop.load(in);
	            //��ȡ��Ϣ   
/*	            url = prop.getProperty("url");
	            driverClass = prop.getProperty("driverClass");
	            userName = prop.getProperty("user");
	            password = prop.getProperty("password"); */
              /*  url="jdbc:mysql://39.108.188.71:3306/travel?characterEncoding=utf-8";
                driverClass="com.mysql.jdbc.Driver";
                userName="root";
                password="root";*/
               url="jdbc:mysql://127.0.0.1:3306/Travel?characterEncoding=utf-8";
                driverClass="com.mysql.jdbc.Driver";
                userName="root";
                password="";
	            //ע����������
	           try{   
	                //����MySql��������   
	                Class.forName(driverClass) ;   
	                }catch(ClassNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("���̳���ע�����");
	        }
	    }
	    /**
	     * �����ݿ���������*/
	    public static Connection getConnection(){
	        try {
	            Connection conn = DriverManager.getConnection(url, userName, password);
	            return conn;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	    }



	    /**
	     * ���������ر�����(˳��:��򿪵��ȹر�)
	     */
	    public static void release(ResultSet rs,Statement stmt,Connection conn){
	        if(rs!=null)
	            try {
	                rs.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	                throw new RuntimeException(e1);
	            }
	        if(stmt!=null){
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	                throw new RuntimeException(e);
	            }
	        }
	        if(conn!=null){
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	                throw new RuntimeException(e);
	            }
	        }
	    }
}