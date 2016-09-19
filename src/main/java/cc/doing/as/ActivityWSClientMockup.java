package cc.doing.as;

import java.net.URI;
import java.net.URISyntaxException;

public class ActivityWSClientMockup implements Runnable{

	public void run() {
		 // open websocket
        WebsocketClientEndpoint clientEndPoint = null;
		try {
			clientEndPoint = new WebsocketClientEndpoint(new URI("ws://localhost:8080/websocket/activity"));
	        
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(;;){
			// wait 5 seconds for messages from websocket
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// send message to websocket
	        clientEndPoint.sendMessage("chrome.exe@@@www.baidu.com@@@baidu yixia ni jiu zh idao!!!@@@"+System.currentTimeMillis()/1000);
		}
	}

}
