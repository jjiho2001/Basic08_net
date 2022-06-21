

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
			
			//------------인코딩 코드 확인하기(header 정보 확인)-------------------------
			// URLConnection 객체를 통해 header 정보를 얻어올 수 있다.
			URLConnection connection = url.openConnection();
			connection.connect(); // 채널 확보하여 header 정보 가져오기
			String header = connection.getContentType();
			String encode = header.substring(header.indexOf("=") + 1); // UTF-8, euc-kr
			//--------------------------------------------------------------------
			InputStream is = url.openStream(); // byte단위로 처리
			InputStreamReader isr = new InputStreamReader(is, encode); // 문자단위처리를 위해 선언
			BufferedReader br = new BufferedReader(isr); // 한 줄씩 처리
			
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
