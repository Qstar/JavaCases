package util.IO;

import java.io.*;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * read()方法要么返回下一次从流里读取的字节数（0到255，包括0和255），要么在达到流的末端时返回-1。
 * 参考：java.io.InputStream.read()。
 */
public class ReadBuffer {
    public static void main(String[] args) {
        //从输入流里读取块数据
        File f = new File("");
        InputStream in = null;
        try {
            in = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            byte[] buf = new byte[100];
            while (true) {
                int n = in.read(buf);
                if (n == -1)
                    break;
                //(...process buf with offset = 0 and length = n...)
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
