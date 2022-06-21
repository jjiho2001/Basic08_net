import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class MulticastReceive {

	MulticastSocket ms;
	DatagramPacket dp;
	InetAddress ia;
	final int PORT = 20000;
	public MulticastReceive() {
		try {
			ms = new MulticastSocket(PORT);
			ia = InetAddress.getByName("230.100.100.2");
			
			InetSocketAddress isa = new InetSocketAddress(ia, PORT);
			NetworkInterface ni = NetworkInterface.getByName("a");
			ms.joinGroup(isa, ni);
			
			byte[] data = new byte[512];
			dp = new DatagramPacket(data, data.length);
			ms.receive(dp); // 받기 대기중
			
			System.out.println(new String(dp.getData(), 0, dp.getLength()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MulticastReceive();

	}

}
