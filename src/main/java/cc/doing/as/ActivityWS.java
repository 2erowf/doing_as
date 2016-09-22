package cc.doing.as;

import cc.doing.as.dao.Activity;
import cc.doing.as.dao.ActivityDAO;
import org.omg.CORBA.INTERNAL;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Date;

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
        //agent_id@@@@@p_name@@@@@window_text@@@@@url@@@@@duration@@@@@datetime(milliseconds since epoch time)
        String[] parts = message.split("@@@@@");
        if(parts.length == 6){
            Activity activity = new Activity();
            activity.setAgentId(parts[0]);
            activity.setpName(parts[1]);
            activity.setWindowText(parts[2]);
            activity.setUrl(parts[3]);
            activity.setDuration(Integer.parseInt(parts[4]));
            activity.setDateTime(new Date(Long.parseLong(parts[5])));
            //activity constructed
            ActivityDAO ad = new ActivityDAO();
            ad.insertActivity(activity);
        }
		System.out.println("incoming message : " + message);
    }

}
