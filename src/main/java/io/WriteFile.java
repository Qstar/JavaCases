package io;

import java.io.*;

public class WriteFile {
    public static void main(String[] args) {
        try {
            //字节流
//            StreamWrite();
//            RandomAccessFileWrite();
//            ByteWrite();
//            fileAppend();

            //字符流
            charWrite();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流
     * 向文件中写入字符串
     */
    public static void StreamWrite() throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        OutputStream out = new FileOutputStream(f);
        String str = "你好";
        byte[] b = str.getBytes();
        out.write(b);
        out.close();
    }

    /**
     * 使用RandomAccessFile写入文件
     * 如果你此时打开hello.txt查看的话，会发现那是乱码。
     */
    public static void RandomAccessFileWrite() throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        RandomAccessFile demo = new RandomAccessFile(f, "rw");
        demo.writeBytes("asdsad");
        demo.writeInt(12);
        demo.writeBoolean(true);
        demo.writeChar('A');
        demo.writeFloat(1.21f);
        demo.writeDouble(12.123);
        demo.close();
    }

    /**
     * 字节流
     * 向文件中一个字节一个字节的写入字符串
     */
    public static void ByteWrite() throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        OutputStream out = new FileOutputStream(f);
        String str = "你好";
        byte[] b = str.getBytes();
        for (byte aB : b) {
            out.write(aB);
        }
        out.close();
    }

    public static void fileAppend() throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        OutputStream out = new FileOutputStream(f, true);
        String str = "Rollen";
        //String str="\r\nRollen"; 可以换行
        byte[] b = str.getBytes();
        for (byte aB : b) {
            out.write(aB);
        }
        out.close();
    }

    public static void charWrite() throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        Writer out = new FileWriter(f);
        String str = "hello";
        out.write(str);
        out.close();
    }
}
