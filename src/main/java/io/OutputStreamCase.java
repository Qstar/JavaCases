package io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 使用OutputStream向屏幕上输出内容
 */
public class OutputStreamCase {
    public static void main(String[] args) throws IOException {
        OutputStream out = System.out;
        try {
            out.write("hello".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
