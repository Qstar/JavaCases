package ssl;

/*
  1.调用keytool命令为服务端生成数字证书和保存它使用的证书仓库：
  keytool -genkey -v -alias bluedash-ssl-demo-server -keyalg RSA -keystore ./server_ks -dname "CN=localhost,OU=cn,O=cn,L=cn,ST=cn,C=cn" -storepass server -keypass 123123

  2.生成一个证书加一个仓库（客户端证书加仓库）
  keytool -genkey -v -alias bluedash-ssl-demo-client -keyalg RSA -keystore ./client_ks -dname "CN=localhost,OU=cn,O=cn,L=cn,ST=cn,C=cn" -storepass client -keypass 456456

  3.接下来，我们要把服务端的证书导出来，并导入到客户端的仓库。第一步是导出服务端的证书：
  keytool -export -alias bluedash-ssl-demo-server -keystore ./server_ks -file server_key.cer
  (Enter keystore password:  server)

  4.然后是把导出的证书导入到客户端证书仓库：
  keytool -import -trustcacerts -alias bluedash-ssl-demo-server -file ./server_key.cer -keystore ./client_ks
  (Enter keystore password:  client)

  5.把客户端的证书导出来，并导入到服务端的证书仓库：
  keytool -export -alias bluedash-ssl-demo-client -keystore ./client_ks -file client_key.cer
  (Enter keystore password:  client）

  6.keytool -import -trustcacerts -alias bluedash-ssl-demo-client -file ./client_key.cer -keystore ./server_ks
  (Enter keystore password:  server)
 */


import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;

public class SSLServer extends Thread {
    private Socket socket;

    public SSLServer(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            String data = reader.readLine();
            writer.println(data);
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    private static String SERVER_KEY_STORE = "/Users/liweinan/projs/ssl/src/main/resources/META-INF/server_ks";
    private static String SERVER_KEY_STORE = "C:/Users/shuaiqiao/server_ks";
    private static String SERVER_KEY_STORE_PASSWORD = "123123";

    public static void main(String[] args) throws Exception {
        System.setProperty("javax.net.ssl.trustStore", SERVER_KEY_STORE);
        SSLContext context = SSLContext.getInstance("TLS");

        KeyStore ks = KeyStore.getInstance("jceks");
        ks.load(new FileInputStream(SERVER_KEY_STORE), null);
        KeyManagerFactory kf = KeyManagerFactory.getInstance("SunX509");
        kf.init(ks, SERVER_KEY_STORE_PASSWORD.toCharArray());
        context.init(kf.getKeyManagers(), null, null);
        ServerSocketFactory factory = context.getServerSocketFactory();
        ServerSocket _socket = factory.createServerSocket(8443);
        //单向认证
        ((SSLServerSocket) _socket).setNeedClientAuth(false);
        //双向认证
        ((SSLServerSocket) _socket).setNeedClientAuth(true);

        while (true) {
            new SSLServer(_socket.accept()).start();
        }
    }
}