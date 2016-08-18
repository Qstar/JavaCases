package io;

import java.io.*;

public class TransferStream {
    public static void main(String[] args) {
        try {
//            outputStreamByteToChar();
            inputStreamByteToChar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节输出流转化为字符输出流
     *
     * @throws IOException 文件不存在
     */
    public static void outputStreamByteToChar() throws IOException {
        String fileName = "d:" + File.separator + "hello.txt";
        File file = new File(fileName);
        Writer out = new OutputStreamWriter(new FileOutputStream(file));
        out.write("hello");
        out.close();
    }

    /**
     * 字节输入流变为字符输入流
     *
     * @throws IOException 文件不存在
     */
    public static void inputStreamByteToChar() throws IOException {
        String fileName = "d:" + File.separator + "hello.txt";
        File file = new File(fileName);
        Reader read = new InputStreamReader(new FileInputStream(file));
        char[] b = new char[100];
        int len = read.read(b);
        System.out.println(new String(b, 0, len));
        read.close();

    }
}
