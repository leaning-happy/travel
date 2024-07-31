package servlets;

import java.io.IOException;
//import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import websocket.SocketServer;
@ServerEndpoint("/servlets/ChatServelt")
public class ChatServlet {
	private static List<Session> sessions = new ArrayList<>();
	@javax.websocket.OnOpen
	public void OnOpen(Session session, @PathParam("username") String username) {
        sessions.add(session);
        System.out.println("nihao");
    }
	@OnMessage
	public void OnMsg(String msg){
		System.out.println("nihao");
    }
	@javax.websocket.OnClose
	public void OnClose(Session session) {
        sessions.remove(session);
    }	
}
