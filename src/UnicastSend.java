import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UnicastSend {
	
	DatagramSocket ds;
	DatagramPacket dp;
	InetAddress ia;
	public UnicastSend() {
		String str = "Sprting framework, ������ �����ӿ�ũ";
		try {
			// ���� ������ ��
			ds = new DatagramSocket();
			
			// UDP����� ������ ���� ��� DatagramPacket�� �����Ͽ� �����Ѵ�.
			byte[] data = str.getBytes();
			ia = InetAddress.getByName("172.30.1.17");
			//                     ����������              �޴���
			dp = new DatagramPacket(data, 0, data.length, ia, 12000);
			// �����ϱ�
			ds.send(dp);
			
			System.out.println("-------���� �Ϸ�-------");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		new UnicastSend();
	}

}
