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
//服务端获取各个port的通信
    public String getchat(Integer port,String name) throws IOException {
    	boolean OVER_FLAG = false;
    	while(!OVER_FLAG) {
    	ServerSocket serverSocket =new ServerSocket(port);
		Socket socket = serverSocket.accept();
		//2.监听来自客户端的请求   并返回Socket实例			
    	InputStream is = socket.getInputStream();
		//3.获取输入流  	 			
    	InputStreamReader isr =new InputStreamReader(is,"utf-8");
        //字节流包装为字符流			
    	BufferedReader bf = new BufferedReader(isr);   //添加进缓存			
    	//4.从缓存中读取数据					
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
//客户端发送通信
    public void sendchat(Integer port,String scan) throws IOException {
    	while(true) {
	    Socket socket=new Socket("127.0.0.1",port); 
	    if(scan!=null) {				        	        			
	//回馈给客户端			
	        OutputStream os = socket.getOutputStream();			 
	        PrintWriter pw = new PrintWriter(os);			
	//3.发送数据			
	        pw.write(scan);
	        pw.flush();					
	//4.关闭资源			
	        os.close();			
	        pw.close();			
            socket.shutdownOutput();
            socket.close();
            }
	    }
    }
}
 

