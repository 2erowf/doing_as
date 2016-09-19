package cc.doing.as;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/websocket/activity")
public class ActivityWS {
	@OnOpen
	public void onOpen(Session session){
		
	}
	@OnClose
    public void end() {
		System.out.println("conn closed");
    }
	@OnMessage
    public void incoming(String message) {
		System.out.println("incoming message : " + message);
    }

}
