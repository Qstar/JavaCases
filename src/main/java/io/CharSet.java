package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 乱码的产生
 * 一般情况下产生乱码，都是由于编码不一致的问题。
 */
public class CharSet {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "hello.txt");
        OutputStream out = new FileOutputStream(file);
        byte[] bytes = "你好".getBytes("ISO8859-1");
        out.write(bytes);
        out.close();
    }
}
