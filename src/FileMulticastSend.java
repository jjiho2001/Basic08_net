import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class FileMulticastSend {

	MulticastSocket ms;
	DatagramPacket dp;
	InetAddress ia;
	final int PORT = 20000;
	public FileMulticastSend() {
		// TODO Auto-generated constructor stub
	}

	void sendStart() {
		try {
			ms = new MulticastSocket();
			ia = InetAddress.getByName("230.100.100.2");
			
			File f = new File("C://Users/Jiho Jung/Desktop/dev/cat_example.jpg");
			FileInputStream fis = new FileInputStream(f);
			
			String sendFileName = "[][][][][]" + f.getName();
			dp = new DatagramPacket(sendFileName.getBytes(), 0, sendFileName.getBytes().length, ia, PORT);
			ms.send(dp);
			
			int cnt = 0;
			while(true) {
				byte[] b = new byte[512];
				int byteCount = fis.read(b, 0, b.length);
				System.out.println(++cnt + ", byte = " + byteCount);
				if(byteCount <= 0) break;
				dp = new DatagramPacket(b, 0, byteCount, ia, PORT);
				ms.send(dp);
			}
			
			String endMessage = "][][][][][";
			dp = new DatagramPacket(endMessage.getBytes(), 0, endMessage.getBytes().length, ia, PORT);
			ms.send(dp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FileMulticastSend().sendStart();
	}
}
