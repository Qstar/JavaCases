package Network.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        //定义服务器的地址,端口号,数据
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8800;
        byte[] data = "用户名: admin;密码: 123".getBytes();
        //创建数据报,包含发送的数据信息
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        //创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);

        //接受服务器端响应的数据
        byte[] data2 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data2, data2.length);
        //接受响应数据
        socket.receive(packet1);
        //读取数据
        String reply = new String(data2, 0, packet1.getLength());
        System.out.println("我是客户端,服务器说: " + reply);
        socket.close();
    }
}
