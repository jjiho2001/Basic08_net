

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
// 172.30.1.17
public class SocketTest {

	Socket s;
	public SocketTest() {
		try {
			InetAddress ia = InetAddress.getByName("172.30.1.17");
			s = new Socket(ia, 10000); // 객체가 만들어진 시점에서 서버에 접속된 것
			System.out.println("서버에 접속됨...");
			
			// server에서 보낸 문자 받기
			InputStream is = s.getInputStream(); // 1byte씩 읽음
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String str = br.readLine();
			System.out.println("받은 문자 : " + str);
			
			// client가 server에게 문자 보내기
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			pw.println("client -> server : client가 server로 문자 보냄...");
			pw.flush();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("client 종료...");
	}

	public static void main(String[] args) {
		new SocketTest();

	}

}
