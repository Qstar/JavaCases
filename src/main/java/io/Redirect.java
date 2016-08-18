package io;

import java.io.*;

public class Redirect {
    public static void main(String[] args) {
//        systemOut();
//        systemErr();
        systemIn();
    }

    /**
     * 为System.out.println()重定向输出
     */
    public static void systemOut() {
        // 此刻直接输出到屏幕
        System.out.println("hello");
        File file = new File("d:" + File.separator + "hello.txt");
        try {
            System.setOut(new PrintStream(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("这些内容在文件中才能看到哦！");
    }

    /**
     * System.err重定向 这个例子也提示我们可以使用这种方法保存错误信息
     */
    public static void systemErr() {
        File file = new File("d:" + File.separator + "hello.txt");
        System.err.println("这些在控制台输出");
        try {
            System.setErr(new PrintStream(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.err.println("这些在文件中才能看到哦！");
    }

    /**
     * System.in重定向
     */
    public static void systemIn() {
        File file = new File("d:" + File.separator + "hello.txt");
        if (file.exists()) {
            try {
                System.setIn(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            byte[] bytes = new byte[1024];
            int len = 0;
            try {
                len = System.in.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("读入的内容为：" + new String(bytes, 0, len));
        }
    }
}
