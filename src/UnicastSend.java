import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UnicastSend {
	
	DatagramSocket ds;
	DatagramPacket dp;
	InetAddress ia;
	public UnicastSend() {
		String str = "Sprting framework, 스프링 프레임워크";
		try {
			// 정보 보내는 곳
			ds = new DatagramSocket();
			
			// UDP방식의 정보를 보낼 경우 DatagramPacket을 생성하여 전송한다.
			byte[] data = str.getBytes();
			ia = InetAddress.getByName("172.30.1.17");
			//                     보낼데이터              받는컴
			dp = new DatagramPacket(data, 0, data.length, ia, 12000);
			// 전송하기
			ds.send(dp);
			
			System.out.println("-------전송 완료-------");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		new UnicastSend();
	}

}
