package util.IO;

import java.io.*;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * BufferedReader对象的创建显得很冗长。这是因为Java把字节和字符当成两个不同的概念来看待（这与C语言不同）。
 * 你可以使用任何类型的InputStream来代替FileInputStream，比如socket。
 * 当达到流的末端时，BufferedReader.readLine()会返回null。
 * 要一次读取一个字符，使用Reader.read()方法。
 * 你可以使用其他的字符编码而不使用UTF-8，但最好不要这样做。
 * 参考：java.io.BufferedReader、java.io.InputStreamReader。
 */
public class ReadFile {
    public static void main(String[] args) {
        File f = new File("");
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(f), "UTF-8"));
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while (true) {
                String line = null;
                if (in != null) {
                    line = in.readLine();
                }
                if (line == null)
                    break;
                //(... process line ...)
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
