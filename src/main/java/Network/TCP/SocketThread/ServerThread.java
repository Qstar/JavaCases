package Network.TCP.SocketThread;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //获取输入流,读取客户端信息
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info;
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器,客户端说: " + info);
            }
            socket.shutdownInput();
            //获取输出流,响应客户端请求
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎您!");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                if (pw != null)
                    pw.close();
                if (os != null)
                    os.close();
                if (br != null)
                    br.close();
                if (isr != null)
                    isr.close();
                if (is != null)
                    is.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
