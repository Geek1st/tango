package com.geeklib.tango.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/Notification",encoders= {ServerEncoder.class})
public class Notification {

	private static Set<Session> sessionList = new HashSet<Session>();
	public static Set<Session> getSessionList() {
		return sessionList;
	}
	
	public static void broadcast(Map<String,String> message) {
		
		for (Session session : sessionList) {
			try {
				session.getBasicRemote().sendObject(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EncodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@OnMessage
	public void onMessage(String message) {
		
		System.out.println(message);
		
//		try {
//			for (Session session : sessionList) {
//				session.getBasicRemote().sendObject(message);;
//			}
//	        
//		}catch(IOException e) {
//			e.printStackTrace();
//			
//		} catch (EncodeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		sessionList.add(session);
		System.out.println("open");
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("close");
		sessionList.remove(session);
	}
	
	@OnError
	public void onError(Throwable throwable) throws Throwable{
		System.out.println("error");
	}
}
