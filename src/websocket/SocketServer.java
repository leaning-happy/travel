package websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketServer{
//����˻�ȡ����port��ͨ��
    public String getchat(Integer port,String name) throws IOException {
    	boolean OVER_FLAG = false;
    	while(!OVER_FLAG) {
    	ServerSocket serverSocket =new ServerSocket(port);
		Socket socket = serverSocket.accept();
		//2.�������Կͻ��˵�����   ������Socketʵ��			
    	InputStream is = socket.getInputStream();
		//3.��ȡ������  	 			
    	InputStreamReader isr =new InputStreamReader(is,"utf-8");
        //�ֽ�����װΪ�ַ���			
    	BufferedReader bf = new BufferedReader(isr);   //��ӽ�����			
    	//4.�ӻ����ж�ȡ����					
    	String info = null;
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while((info=bf.readLine()) != null) {				
			info=name+df.format(new Date())+"\r\n"+info;			
			if("OVER".equals(info)) {		        	
				OVER_FLAG = true;		        	
				break;		        }
		}
		socket.shutdownInput();			   		
		socket.close();			   		
		is.close();					    		
		bf.close();			
		serverSocket.close();
		return info;
    	}
    	return null;
    }
//�ͻ��˷���ͨ��
    public void sendchat(Integer port,String scan) throws IOException {
    	while(true) {
	    Socket socket=new Socket("127.0.0.1",port); 
	    if(scan!=null) {				        	        			
	//�������ͻ���			
	        OutputStream os = socket.getOutputStream();			 
	        PrintWriter pw = new PrintWriter(os);			
	//3.��������			
	        pw.write(scan);
	        pw.flush();					
	//4.�ر���Դ			
	        os.close();			
	        pw.close();			
            socket.shutdownOutput();
            socket.close();
            }
	    }
    }
}
 

