

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public InetAddressTest() {
		// TODO Auto-generated constructor stub
	}

	void start() {
		// ip�� ���õ� ��ü�� �����Ѵ�.
		// �� ��ǻ���� ������ ���� ������
		
		try {
			InetAddress ia = InetAddress.getLocalHost();
			
			// �� ��ǻ�� ip
			String ip = ia.getHostAddress();
			String name = ia.getHostName();
			System.out.println("ip -> " + ip + " name -> " + name);
			
			// ������ �̿��� InetAddress�� ������
			InetAddress ia2 = InetAddress.getByName("www.naver.com");
			System.out.println("ia2.address -> " + ia2.getHostAddress());
			System.out.println("1a2.name -> " + ia2.getHostName());
			
			// �����Ǹ� �̿��� InetAddress�� ������
			InetAddress ia3 = InetAddress.getByName("223.130.195.200");
			System.out.println("ia3.address -> " + ia3.getHostAddress());
			System.out.println("1a3.name -> " + ia3.getHostName());
			
			// �������� InetAddress ��ü ������
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
