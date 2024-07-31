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
      //ʹ������ѭ����������ѭ����ʵ�ֿͻ�����������ĶԻ�
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} 
        	Scanner scanner = new Scanner(System.in);
//    		String data = null;			
    		System.out.println("�ͻ��ˣ�");				        
    		String data1 = scanner.nextLine();	        			
    		//�������ͻ���			
    		OutputStream os = null;			
            try {
				os = socket.getOutputStream();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}			 
    		PrintWriter pw = new PrintWriter(os);			
    		//3.��������			
    		pw.write(data1);
    		pw.flush();					
    		//4.�ر���Դ			    		
			try {
				os.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} 			
    		pw.close();			
//    		scanner.close();
    	    try {
				socket.shutdownOutput();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
    	    try {
				socket.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
//    	    System.out.println("�ȴ�����"); //1.�ȴ�����
    	    Socket socket = null;
			try {
				socket = serverSocket.accept();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}	//2.�������Կͻ��˵�����   ������Socketʵ��			
//    	    System.out.println("�������");			
    	    InputStream is = null;
			try {
				is = socket.getInputStream();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}	//3.��ȡ������  	InputStream is = socket.getInputStream();  			
    		InputStreamReader isr = null;
			try {
				isr = new InputStreamReader(is,"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}  //�ֽ�����װΪ�ַ���			
    		BufferedReader bf = new BufferedReader(isr);   //��ӽ�����			
    		//4.�ӻ����ж�ȡ����					
    		String info = null;						
    		try {
				while((info=bf.readLine()) != null) {				
					System.out.println("����ˣ�"+info);				
					if("OVER".equals(info)) {		        	
						OVER_FLAG = true;		        	
						break;		        }
						}
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}	
    		try {
				socket.shutdownInput();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
    		try {
				socket.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
    		try {
				is.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}			
    		try {
				bf.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
//   		System.out.println("����˷�����һ����Ϣ");
    		try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
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
		System.out.print("�ͻ��ˣ�");				        
		String data1 = scanner.nextLine();	        			
		//�������ͻ���			
		OutputStream os = socket.getOutputStream();			 
		PrintWriter pw = new PrintWriter(os);			
		//3.��������			
		pw.write(data1);
		pw.flush();					
		//4.�ر���Դ			
		os.close();			
		pw.close();			
		scanner.close();
	    socket.shutdownOutput();	}		
		}*/
    /*
    public static void getmessage() throws IOException {
    	ServerSocket serverSocket=new ServerSocket(43214);
	    System.out.println("�ȴ�����"); //1.�ȴ�����
	    Socket socket=serverSocket.accept();	//2.�������Կͻ��˵�����   ������Socketʵ��			
	    System.out.println("�������");			
	    InputStream is = socket.getInputStream();	//3.��ȡ������  	InputStream is = socket.getInputStream();  			
		InputStreamReader  isr = new InputStreamReader(is,"utf-8");  //�ֽ�����װΪ�ַ���			
		BufferedReader bf = new BufferedReader(isr);   //��ӽ�����			
		//4.�ӻ����ж�ȡ����					
		String info = null;						
		while((info=bf.readLine()) != null) {				
			System.out.println("�����˵��"+info);				
			if("OVER".equals(info)) {		        	
				OVER_FLAG = true;		        	
				break;		        }
				}	
		socket.shutdownInput();
		socket.close();
		is.close();			
		bf.close();
		System.out.println("����˷�����һ����Ϣ");
		serverSocket.close();
        }*/
}

