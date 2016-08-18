package io;

import java.io.*;

public class DataStreamCase {
    public static void main(String[] args) {
        try {
            DataOutputStreamDemo();
            DataInputStreamDemo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void DataOutputStreamDemo() throws IOException {
        File file = new File("d:" + File.separator + "hello.txt");
        char[] ch = {'A', 'B', 'C'};
        DataOutputStream out;
        out = new DataOutputStream(new FileOutputStream(file));
        for (char temp : ch) {
            out.writeChar(temp);
        }
        out.close();
    }

    public static void DataInputStreamDemo() throws IOException {
        File file = new File("d:" + File.separator + "hello.txt");
        DataInputStream input = new DataInputStream(new FileInputStream(file));
        char[] ch = new char[10];
        int count = 0;
        char temp;
        while ((temp = input.readChar()) != 'C') {
            ch[count++] = temp;
        }
        System.out.println(ch);
    }
}
