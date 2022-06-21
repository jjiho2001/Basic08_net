import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSend {
	// 224.0.0.0 ~ 239.255.255.255 �� �ȿ��� ��󾲸� ��
	// 230.100.100.2 ����
	
	MulticastSocket ms;
	DatagramPacket dp;
	InetAddress ia;
	final int PORT = 20000;
	public MulticastSend() {
		
		// ���� ���� 
		String str = "Multicast�� �̿��� ��� ������..";
		try {
			ms = new MulticastSocket();
			ia = InetAddress.getByName("230.100.100.2");
			dp = new DatagramPacket(str.getBytes(), 0, str.getBytes().length, ia, PORT);
			
			ms.send(dp);
			System.out.println("���� �Ϸ�...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MulticastSend();

	}

}
