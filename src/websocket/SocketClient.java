package websocket;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ClientInfoStatus;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class SocketClient{	
	static boolean OVER_FLAG = false;
    public static void main(String[] args)  {
      //使用无线循环或者有限循环来实现客户端与服务器的对话
    	SocketClient cli=new SocketClient();
    	Thread t1=cli.new TestThread1();
    	Thread t2=cli.new TestThread2();
    	t1.start();
    	t2.start();
    }  
    public class TestThread1 extends Thread{
    	public TestThread1(){
    		super();
    	}
    	public void run() {
    		while(true) {
    		Socket socket = null;
    		try {
				socket = new Socket("127.0.0.1",43213);
			} catch (UnknownHostException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} 
        	Scanner scanner = new Scanner(System.in);
//    		String data = null;			
    		System.out.println("客户端：");				        
    		String data1 = scanner.nextLine();	        			
    		//回馈给客户端			
    		OutputStream os = null;			
            try {
				os = socket.getOutputStream();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}			 
    		PrintWriter pw = new PrintWriter(os);			
    		//3.发送数据			
    		pw.write(data1);
    		pw.flush();					
    		//4.关闭资源			    		
			try {
				os.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} 			
    		pw.close();			
//    		scanner.close();
    	    try {
				socket.shutdownOutput();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    	    try {
				socket.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    	}}
    }
    public class TestThread2 extends Thread{
    	public TestThread2(){
    		super();
    	}
    	public void run() {
    		while(!OVER_FLAG) {
    		ServerSocket serverSocket = null;
			try {
				serverSocket = new ServerSocket(43214);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
//    	    System.out.println("等待连接"); //1.等待连接
    	    Socket socket = null;
			try {
				socket = serverSocket.accept();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}	//2.监听来自客户端的请求   并返回Socket实例			
//    	    System.out.println("完成连接");			
    	    InputStream is = null;
			try {
				is = socket.getInputStream();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}	//3.获取输入流  	InputStream is = socket.getInputStream();  			
    		InputStreamReader isr = null;
			try {
				isr = new InputStreamReader(is,"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}  //字节流包装为字符流			
    		BufferedReader bf = new BufferedReader(isr);   //添加进缓存			
    		//4.从缓存中读取数据					
    		String info = null;						
    		try {
				while((info=bf.readLine()) != null) {				
					System.out.println("服务端："+info);				
					if("OVER".equals(info)) {		        	
						OVER_FLAG = true;		        	
						break;		        }
						}
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}	
    		try {
				socket.shutdownInput();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    		try {
				socket.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    		try {
				is.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}			
    		try {
				bf.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
//   		System.out.println("服务端发送了一次信息");
    		try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    	}}
    }
    /*
    public static void sendmessage() throws IOException {
    	Socket socket=new Socket("127.0.0.1",43213);
    	Scanner scanner = new Scanner(System.in);
		if(scanner!=null) {
//		String data = null;			
		System.out.print("客户端：");				        
		String data1 = scanner.nextLine();	        			
		//回馈给客户端			
		OutputStream os = socket.getOutputStream();			 
		PrintWriter pw = new PrintWriter(os);			
		//3.发送数据			
		pw.write(data1);
		pw.flush();					
		//4.关闭资源			
		os.close();			
		pw.close();			
		scanner.close();
	    socket.shutdownOutput();	}		
		}*/
    /*
    public static void getmessage() throws IOException {
    	ServerSocket serverSocket=new ServerSocket(43214);
	    System.out.println("等待连接"); //1.等待连接
	    Socket socket=serverSocket.accept();	//2.监听来自客户端的请求   并返回Socket实例			
	    System.out.println("完成连接");			
	    InputStream is = socket.getInputStream();	//3.获取输入流  	InputStream is = socket.getInputStream();  			
		InputStreamReader  isr = new InputStreamReader(is,"utf-8");  //字节流包装为字符流			
		BufferedReader bf = new BufferedReader(isr);   //添加进缓存			
		//4.从缓存中读取数据					
		String info = null;						
		while((info=bf.readLine()) != null) {				
			System.out.println("服务端说："+info);				
			if("OVER".equals(info)) {		        	
				OVER_FLAG = true;		        	
				break;		        }
				}	
		socket.shutdownInput();
		socket.close();
		is.close();			
		bf.close();
		System.out.println("服务端发送了一次信息");
		serverSocket.close();
        }*/
}

