package io;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        try {
            //字节流
//            readStream();
//            readStream1();
//            readStream2();
//            readByte();

            //字符流
//            readChar();
            readChar1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流
     * 读文件内容
     *
     * @throws IOException 文件不存在
     */
    public static void readStream() throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[1024];
        int len = in.read(b);
        System.out.println(new String(b));
        System.out.println("读入长度为：" + len);
        System.out.println(new String(b, 0, len));
        in.close();
    }

    /**
     * 需要准确的大小，这样节省空间
     *
     * @throws IOException 文件不存在
     */
    public static void readStream1() throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[(int) f.length()];
        in.read(b);
        System.out.println("文件长度为：" + f.length());
        in.close();
        System.out.println(new String(b));
    }

    /**
     * 字节流
     * 读文件
     * 不知道文件有多大,需要判断是否独到文件的末尾
     *
     * @throws IOException
     */
    public static void readStream2() throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[1024];
        int count = 0;
        int temp;
        while ((temp = in.read()) != (-1)) {
            b[count++] = (byte) temp;
        }
        in.close();
        System.out.println(new String(b));
    }

    /**
     * 字节流
     * 读文件内容,节省空间
     *
     * @throws IOException 文件不存在
     */
    public static void readByte() throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[(int) f.length()];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) in.read();
        }
        in.close();
        System.out.println(new String(b));
    }

    /**
     * 字符流
     * 从文件中读出内容
     *
     * @throws IOException 文件不存在
     */
    public static void readChar() throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        char[] ch = new char[100];
        Reader read = new FileReader(f);
        int count = read.read(ch);
        read.close();
        System.out.println("读入的长度为：" + count);
        System.out.println("内容为" + new String(ch, 0, count));
    }

    /**
     * 字符流
     * 从文件中读出内容
     * 采用循环读取的方式，因为有时候不知道文件到底有多大
     *
     * @throws IOException 文件不存在
     */
    public static void readChar1() throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        char[] ch = new char[100];
        Reader read = new FileReader(f);
        int temp = 0;
        int count = 0;
        while ((temp = read.read()) != (-1)) {
            ch[count++] = (char) temp;
        }
        read.close();
        System.out.println("内容为" + new String(ch, 0, count));
    }
}
