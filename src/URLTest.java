

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	public URLTest() {
		
	}

	void start() {
		try {
			URL url = new URL("https://www.seoul.go.kr/main/index.jsp");
			System.out.println("protocol -> " + url.getProtocol());
			System.out.println("port -> " + url.getPort());
			System.out.println("host -> " + url.getHost());
			System.out.println("path -> " + url.getPath());
			System.out.println("file -> " + url.getFile());
			
			//------------���ڵ� �ڵ� Ȯ���ϱ�(header ���� Ȯ��)-------------------------
			// URLConnection ��ü�� ���� header ������ ���� �� �ִ�.
			URLConnection connection = url.openConnection();
			connection.connect(); // ä�� Ȯ���Ͽ� header ���� ��������
			String header = connection.getContentType();
			String encode = header.substring(header.indexOf("=") + 1); // UTF-8, euc-kr
			//--------------------------------------------------------------------
			InputStream is = url.openStream(); // byte������ ó��
			InputStreamReader isr = new InputStreamReader(is, encode); // ���ڴ���ó���� ���� ����
			BufferedReader br = new BufferedReader(isr); // �� �پ� ó��
			
			File f = new File("C://Users/Jiho Jung/Desktop/dev/student/seoul.html");
			FileWriter fos = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fos);
			String inData = "";
			
			while((inData = br.readLine()) != null) {
				System.out.println(inData);
				bw.write(inData + "\n");
			}
			bw.close();
			br.close();
			System.out.println("------------------------------------------");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		URLTest ut = new URLTest();
		ut.start();

	}

}
