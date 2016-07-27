package Network.TCP.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//基于TCP协议的SOCKET通信,实现用户登录
public class Server {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            //1.创建服务器端Socket
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("****服务器即将启动,等待客户端连接********");
            //2.调用accept开始监听,等待客户端连接
            Socket socket = serverSocket.accept();
            //3.获取输入流,读取客户端信息
            InputStream is = socket.getInputStream();
            //接受字符串
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(isr);
//            String info;
//            while ((info = br.readLine()) != null) {
//                System.out.println("我是服务器,客户端说: " + info);
//            }
            //接受对象
            ObjectInputStream ois = new ObjectInputStream(is);
            User user = (User) ois.readObject();
            System.out.println("我是服务器,客户端说: 用户名 " + user.getName() + "\t密码 " + user.getPassword());

            socket.shutdownInput();
            //4.获取输出流,响应客户端请求
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("欢迎您!");
            pw.flush();

            //5.关闭资源
            pw.close();
            os.close();
//            br.close();
//            isr.close();
            is.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
