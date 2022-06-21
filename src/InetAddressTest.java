

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public InetAddressTest() {
		// TODO Auto-generated constructor stub
	}

	void start() {
		// ip에 관련된 객체를 생성한다.
		// 내 컴퓨터의 아이피 정보 얻어오기
		
		try {
			InetAddress ia = InetAddress.getLocalHost();
			
			// 내 컴퓨터 ip
			String ip = ia.getHostAddress();
			String name = ia.getHostName();
			System.out.println("ip -> " + ip + " name -> " + name);
			
			// 도메인 이용한 InetAddress를 얻어오기
			InetAddress ia2 = InetAddress.getByName("www.naver.com");
			System.out.println("ia2.address -> " + ia2.getHostAddress());
			System.out.println("1a2.name -> " + ia2.getHostName());
			
			// 아이피를 이용한 InetAddress를 얻어오기
			InetAddress ia3 = InetAddress.getByName("223.130.195.200");
			System.out.println("ia3.address -> " + ia3.getHostAddress());
			System.out.println("1a3.name -> " + ia3.getHostName());
			
			// 여러개의 InetAddress 객체 얻어오기
			InetAddress[] ia4 = InetAddress.getAllByName("www.naver.com");
			for(InetAddress i : ia4) {
				System.out.println("ia4.address -> " + i.getHostAddress());
				System.out.println("1a4.name -> " + i.getHostName());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		InetAddressTest it = new InetAddressTest();
		it.start();
	}
}
