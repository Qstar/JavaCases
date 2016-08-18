package util.IO;

import java.io.*;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * Printwriter对象的创建显得很冗长。这是因为Java把字节和字符当成两个不同的概念来看待（这与C语言不同）。
 * 就像System.out，你可以使用print()和println()打印多种类型的值。
 * 你可以使用其他的字符编码而不使用UTF-8，但最好不要这样做。
 * 参考：java.io.PrintWriter、java.io.OutputStreamWriter。
 */
public class WriteToFile {
    public static void main(String[] args) {
        File f = new File("");
        PrintWriter out = null;
        try {
            out = new PrintWriter(
                    new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            out.print("Hello ");
            out.print(42);
            out.println(" world!");
        } finally {
            out.close();
        }
    }
}
