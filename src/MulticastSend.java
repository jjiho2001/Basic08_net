import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSend {
	// 224.0.0.0 ~ 239.255.255.255 이 안에서 골라쓰면 됨
	// 230.100.100.2 예시
	
	MulticastSocket ms;
	DatagramPacket dp;
	InetAddress ia;
	final int PORT = 20000;
	public MulticastSend() {
		
		// 보낼 내용 
		String str = "Multicast를 이용한 통신 연습중..";
		try {
			ms = new MulticastSocket();
			ia = InetAddress.getByName("230.100.100.2");
			dp = new DatagramPacket(str.getBytes(), 0, str.getBytes().length, ia, PORT);
			
			ms.send(dp);
			System.out.println("전송 완료...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MulticastSend();

	}

}
