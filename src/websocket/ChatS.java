package websocket;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/ChatS")
public class ChatS {
	private static List<Session> sessions = new ArrayList<>();
	@javax.websocket.OnOpen
	public void OnOpen(Session session) {
        sessions.add(session);
    }
	@OnMessage
	public void OnMsg(String msg,Session session) throws UnsupportedEncodingException{
		String query=URLDecoder.decode(session.getQueryString(),"utf-8");
		String name=query.split("=")[1];
		sendTextMsg( name+" "+new Date()+"£º\r\n" + msg);
    }
	@javax.websocket.OnClose
	public void OnClose(Session session) {
        sessions.remove(session);
    }	
	public void sendTextMsg(String msg) {
	        for (Session session : sessions) {
	            session.getAsyncRemote().sendText(msg);
	        }
	    }
	 @javax.websocket.OnError
	 public void OnError(Throwable e) {
	        e.printStackTrace();
	    }
}
