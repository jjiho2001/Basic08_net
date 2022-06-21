

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
			s = new Socket(ia, 10000); // ��ü�� ������� �������� ������ ���ӵ� ��
			System.out.println("������ ���ӵ�...");
			
			// server���� ���� ���� �ޱ�
			InputStream is = s.getInputStream(); // 1byte�� ����
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String str = br.readLine();
			System.out.println("���� ���� : " + str);
			
			// client�� server���� ���� ������
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			pw.println("client -> server : client�� server�� ���� ����...");
			pw.flush();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("client ����...");
	}

	public static void main(String[] args) {
		new SocketTest();

	}

}
