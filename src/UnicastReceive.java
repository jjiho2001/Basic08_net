import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicastReceive {

	DatagramSocket ds;
	DatagramPacket dp;
	public UnicastReceive() {
		try {
			// ���� �޴� ��
			ds = new DatagramSocket(12000);
			// 512byte
			byte data[] = new byte[512];
			dp = new DatagramPacket(data, data.length);
			System.out.println("�ޱ� �����...");
			ds.receive(dp);
			
			// ���� ���� ������ ����ϱ�
			byte[] receiveData = dp.getData();           // ���� ���� ����Ʈ ��  
			System.out.println(new String(receiveData, 0, dp.getLength()));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		new UnicastReceive();
	}

}
