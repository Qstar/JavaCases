package io;

import java.io.*;

public class SequenceStreamCase {
    public static void main(String[] args) {
        try {
            SequenceInputStreamDemo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void SequenceInputStreamDemo() throws IOException {
        File file1 = new File("d:" + File.separator + "hello1.txt");
        File file2 = new File("d:" + File.separator + "hello2.txt");
        File file3 = new File("d:" + File.separator + "hello.txt");
        InputStream input1 = new FileInputStream(file1);
        InputStream input2 = new FileInputStream(file2);
        OutputStream output = new FileOutputStream(file3);
        // 合并流
        SequenceInputStream sis = new SequenceInputStream(input1, input2);
        int temp;
        while ((temp = sis.read()) != -1) {
            output.write(temp);
        }
        input1.close();
        input2.close();
        output.close();
        sis.close();
    }
}
