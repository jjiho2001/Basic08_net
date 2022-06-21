

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

public class ServerSocketTest {

	ServerSocket ss;
	public ServerSocketTest() {
		try {
			// 접속을 대기할 수 있는 ServerSocket은 port 번호를 지정하여 객체를 생성함
			ss = new ServerSocket(10000);
			
			while(true) {
				System.out.println("Server start... 접속 대기중");
				// client 접속을 accept() method가 기다리고
				// 접속을 하면 client 정보가 있는 Socket object를 return 해줌.
				Socket s = ss.accept();
				InetAddress ia = s.getInetAddress();
				
				System.out.println(ia.getHostAddress() + " -> client가 접속하였습니다");
				
				// server에서 client에게 문자보내기
				OutputStream os = s.getOutputStream(); // 1byte로 출력함
				OutputStreamWriter osw = new OutputStreamWriter(os); // 1 문자를 보냄
				PrintWriter pw = new PrintWriter(osw); 
				
				pw.println("server -> client : 서버에 접속되었습니다.");
				pw.flush(); // 실제 데이터가 나가는 시점
				
				// client가 보낸 문자 받기
				InputStream is = s.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				String str = br.readLine();
				System.out.println("받은 문자 : " + str);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("server 종료...");
	}

	public static void main(String[] args) {
		
		new ServerSocketTest();
	}

}
