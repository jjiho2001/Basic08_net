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
			
			// 파일의 내용을 byte 배열로 읽어와 전송하기 위해 InputStream 객체를 생성한다.
			File f = new File("C://Users/Jiho Jung/Desktop/dev/cat_example.jpg");
			FileInputStream fis = new FileInputStream(f);
			
			// 파일명을 전송
			// 앞에 파일명을 판단하게 하는 임의의 문자를 포함(content에서 나오지 않을 만한 문자) + cat_example.jpg
			String sendFileName = "[*&@File&]" + f.getName(); 
			dp = new DatagramPacket(sendFileName.getBytes(), 0, sendFileName.getBytes().length, ia, PORT);
			ds.send(dp); // 파일명 보내기
			
			// 파일 내용 읽어 전송
			int cnt = 0;
			while(true) {
				byte[] b = new byte[512];
				int byteCount = fis.read(b, 0, b.length);
				System.out.println(++cnt + ", byte = " + byteCount);
				if(byteCount <= 0) break;
				dp = new DatagramPacket(b, 0, byteCount, ia, PORT);
				ds.send(dp);
			}
			
			// 전송완료
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
