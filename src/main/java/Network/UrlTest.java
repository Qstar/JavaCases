package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlTest {
    public static void main(String[] args) throws IOException {
        //创建一个Url的实例
        URL immoc = new URL("http://www.imooc.com");
        URL url = new URL(immoc, "/index.html?username=tom#test");
        System.out.println("协议: " + url.getProtocol());
        System.out.println("主机: " + url.getHost());
        System.out.println("端口: " + url.getPort());
        System.out.println("文件路径: " + url.getPath());
        System.out.println("文件名称: " + url.getFile());
        System.out.println("相对路径: " + url.getRef());
        System.out.println("查询字符串: " + url.getQuery());

        //使用URl读取网页内容
        URL url1 = new URL("http://www.baidu.com");
        //通过openStream获取资源字节输入流
        InputStream is = url1.openStream();
        //将字节输入流转换为字符输入流
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        //为字符输入流添加缓冲,优化读取速度
        BufferedReader br = new BufferedReader(isr);
        String data = br.readLine();
        while (data != null) {
            System.out.println(data);
            data = br.readLine();
        }
        br.close();
        isr.close();
        is.close();
    }
}
