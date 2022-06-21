import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class FileUnicastSend {

	DatagramSocket ds;
	DatagramPacket dp;
	InetAddress ia; // 172.30.1.17
	final int PORT = 15000;
	public FileUnicastSend() {
		
	}

	void sendStart() {
		try {
			ds = new DatagramSocket();
			ia = InetAddress.getByName("172.30.1.17");
			
			// ������ ������ byte �迭�� �о�� �����ϱ� ���� InputStream ��ü�� �����Ѵ�.
			File f = new File("C://Users/Jiho Jung/Desktop/dev/cat_example.jpg");
			FileInputStream fis = new FileInputStream(f);
			
			// ���ϸ��� ����
			// �տ� ���ϸ��� �Ǵ��ϰ� �ϴ� ������ ���ڸ� ����(content���� ������ ���� ���� ����) + cat_example.jpg
			String sendFileName = "[*&@File&]" + f.getName(); 
			dp = new DatagramPacket(sendFileName.getBytes(), 0, sendFileName.getBytes().length, ia, PORT);
			ds.send(dp); // ���ϸ� ������
			
			// ���� ���� �о� ����
			int cnt = 0;
			while(true) {
				byte[] b = new byte[512];
				int byteCount = fis.read(b, 0, b.length);
				System.out.println(++cnt + ", byte = " + byteCount);
				if(byteCount <= 0) break;
				dp = new DatagramPacket(b, 0, byteCount, ia, PORT);
				ds.send(dp);
			}
			
			// ���ۿϷ�
			String endMessage = "[@*!&$@]*1";
			dp = new DatagramPacket(endMessage.getBytes(), 0, endMessage.getBytes().length, ia, PORT);
			ds.send(dp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new FileUnicastSend().sendStart();;

	}

}
