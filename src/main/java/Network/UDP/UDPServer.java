package Network.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        //创建服务器端DatagramSocket,指定端口
        DatagramSocket socket = new DatagramSocket(8800);
        //创建数据报,用于接收客户端的数据
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        //接受客户端发送的数据
        System.out.println("*****服务器端已经启动,等待客户端发送数据****");
        socket.receive(packet);//此方法在接收到数据包之前一直阻塞
        //读取数据
        String info = new String(data, 0, packet.getLength());
        System.out.println("我是服务器,客户端说: " + info);

        //向客户端响应数据
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] data2 = "欢迎您!".getBytes();
        //创建数据报
        DatagramPacket packet1 = new DatagramPacket(data2, data2.length, address, port);
        //响应客户端
        socket.send(packet1);
        //关闭资源
        socket.close();
    }
}
