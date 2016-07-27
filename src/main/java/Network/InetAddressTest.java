package Network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("计算机名: " + address.getHostName());
        System.out.println("IP地址: " + address.getHostAddress());
        byte[] bytes = address.getAddress();
        System.out.println("字节数组形式的IP: " + Arrays.toString(bytes));
        System.out.println(address);

        //根据主机名获取InetAddress实例
        InetAddress address1=InetAddress.getByName("bogon");
        System.out.println("计算机名: " + address1.getHostName());
        System.out.println("IP地址: " + address1.getHostAddress());
    }
}
