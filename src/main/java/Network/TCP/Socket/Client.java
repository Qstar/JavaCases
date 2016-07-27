package Network.TCP.Socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            //1.创建客户端Socket,指定服务器地址和端口
            Socket socket = new Socket("localhost", 8888);
            //2.获取输出流,向服务器发送信息
            OutputStream os = socket.getOutputStream();
            //以字符串形式传递
//            PrintWriter pw = new PrintWriter(os);
//            pw.write("用户名: admin;密码: 123");
//            pw.flush();
            //以对象方式传递
            ObjectOutputStream oos = new ObjectOutputStream(os);
            User user = new User("admin", "1234");
            oos.writeObject(user);
            oos.flush();
            socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String info;
            while ((info = br.readLine()) != null) {
                System.out.println("我是客户端,服务器说: " + info);
            }

            //3.关闭资源
            br.close();
            isr.close();
            is.close();
//            pw.close();
            oos.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
