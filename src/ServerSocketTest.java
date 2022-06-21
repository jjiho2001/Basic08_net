

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
			// ������ ����� �� �ִ� ServerSocket�� port ��ȣ�� �����Ͽ� ��ü�� ������
			ss = new ServerSocket(10000);
			
			while(true) {
				System.out.println("Server start... ���� �����");
				// client ������ accept() method�� ��ٸ���
				// ������ �ϸ� client ������ �ִ� Socket object�� return ����.
				Socket s = ss.accept();
				InetAddress ia = s.getInetAddress();
				
				System.out.println(ia.getHostAddress() + " -> client�� �����Ͽ����ϴ�");
				
				// server���� client���� ���ں�����
				OutputStream os = s.getOutputStream(); // 1byte�� �����
				OutputStreamWriter osw = new OutputStreamWriter(os); // 1 ���ڸ� ����
				PrintWriter pw = new PrintWriter(osw); 
				
				pw.println("server -> client : ������ ���ӵǾ����ϴ�.");
				pw.flush(); // ���� �����Ͱ� ������ ����
				
				// client�� ���� ���� �ޱ�
				InputStream is = s.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				String str = br.readLine();
				System.out.println("���� ���� : " + str);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("server ����...");
	}

	public static void main(String[] args) {
		
		new ServerSocketTest();
	}

}
