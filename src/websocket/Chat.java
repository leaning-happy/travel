package websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


	@ServerEndpoint(value = "/websocket")
	public class Chat{

	    //����ֻ�Ǽ򵥲����ã������ĳ����뿼���̰߳�ȫ�����������������������
	    private static List<Session> sessions = new ArrayList<>();

	    /**
	     * @param session  ��ͻ��˵ĻỰ���󡾿�ѡ��
	     * @param username ·������ֵ ����ѡ��
	     * @throws IOException
	     * @OnOpen ��ע�˷����� ws ���ӽ���ʱ���ã�����������һЩ׼���Թ��� ��ѡ����
	     * EndpointConfig���˵�������Ϣ���� Session ���ӻỰ����
	     */
	    @javax.websocket.OnOpen
	    public void OnOpen(Session session, @PathParam("username") String username) throws IOException {
	        sessions.add(session);
	        sendTextMsg("���� [" + username + "] ����Ⱥ��");
	    }

	    /**
	     * @param msg      ���ܿͻ�����Ϣ
	     * @param username RESTful ·����ʽ��ȡ�û���
	     * @throws IOException
	     * @OnMessage ���յ��ͻ�����Ϣ���� ��Ϣ��ʽ�������ı���Ϣ���������Ƕ�������Ϣ(byte[]/ByteBuffer��)��ping/pong ��Ϣ
	     */
	    @OnMessage
	    public void OnMsg(String msg, @PathParam("username") String username) throws IOException {
	        sendTextMsg(username + "��\r\n" + msg);
	    }


	    /**
	     * @OnClose ���ӹرյ���
	     */
	    @javax.websocket.OnClose
	    public void OnClose(Session session, @PathParam("username") String username) throws IOException {
	        sessions.remove(session);
	        sendTextMsg("���� ["+username + "] �˳�Ⱥ��");
	    }

	    /**
	     * @param e �쳣����
	     * @OnError ���ӳ��ִ������
	     */
	    @javax.websocket.OnError
	    public void OnError(Throwable e) {
	        e.printStackTrace();
	    }

	    private void sendTextMsg(String msg) {
	        for (Session session : sessions) {
	            session.getAsyncRemote().sendText(msg);
	        }
	    }
	}

