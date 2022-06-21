import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class FileMulticastReceive {

	MulticastSocket ms;
	DatagramPacket dp;
	FileOutputStream fos;
	InetAddress ia;
	final int PORT = 20000;
	
	public FileMulticastReceive() {
		// TODO Auto-generated constructor stub
	}

	void receiveStart() {
		try {
			ms = new MulticastSocket(PORT);
			ia = InetAddress.getByName("230.100.100.2");
			
			InetSocketAddress isa = new InetSocketAddress(ia, PORT);
			NetworkInterface ni = NetworkInterface.getByName("a");
			ms.joinGroup(isa, ni);
			
			byte[] receiveData = new byte[512];
			dp = new DatagramPacket(receiveData, receiveData.length);
			
			while(true) {
				System.out.println("전송 받기 대기중...");
				ms.receive(dp);
				
				byte[] receive = dp.getData();
				int byteCount = dp.getLength();
				
				String receiveStr = new String(receive, 0, byteCount);
				if(byteCount > 10 && receiveStr.substring(0, 10).equals("[][][][][]")) {
					fos = new FileOutputStream(new File("C://Users/Jiho Jung/Desktop/dev/student", receiveStr.substring(10)));
				} else if(byteCount >= 10 && receiveStr.equals("][][][][][")) {
					fos.close();
					ms.close();
					System.out.println("파일로 저장되었습니다");
					break;
				} else {
					fos.write(receive, 0, byteCount);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new FileMulticastReceive().receiveStart();
	}
}
