import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Host Name: " + localHost.getHostName());
            System.out.println("IP Address: " + localHost.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
