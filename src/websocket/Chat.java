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

	    //这里只是简单测试用，真正的场景请考虑线程安全的容器或其它并发解决方案
	    private static List<Session> sessions = new ArrayList<>();

	    /**
	     * @param session  与客户端的会话对象【可选】
	     * @param username 路径参数值 【可选】
	     * @throws IOException
	     * @OnOpen 标注此方法在 ws 连接建立时调用，可用来处理一些准备性工作 可选参数
	     * EndpointConfig（端点配置信息对象） Session 连接会话对象
	     */
	    @javax.websocket.OnOpen
	    public void OnOpen(Session session, @PathParam("username") String username) throws IOException {
	        sessions.add(session);
	        sendTextMsg("好友 [" + username + "] 加入群聊");
	    }

	    /**
	     * @param msg      接受客户端消息
	     * @param username RESTful 路径方式获取用户名
	     * @throws IOException
	     * @OnMessage 在收到客户端消息调用 消息形式不限于文本消息，还可以是二进制消息(byte[]/ByteBuffer等)，ping/pong 消息
	     */
	    @OnMessage
	    public void OnMsg(String msg, @PathParam("username") String username) throws IOException {
	        sendTextMsg(username + "：\r\n" + msg);
	    }


	    /**
	     * @OnClose 连接关闭调用
	     */
	    @javax.websocket.OnClose
	    public void OnClose(Session session, @PathParam("username") String username) throws IOException {
	        sessions.remove(session);
	        sendTextMsg("好友 ["+username + "] 退出群聊");
	    }

	    /**
	     * @param e 异常参数
	     * @OnError 连接出现错误调用
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

