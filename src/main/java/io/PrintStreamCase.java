package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamCase {
    public static void main(String[] args) {
        try {
            printStreamOut();
            printStreamOut1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用PrintStream进行输出
     *
     * @throws IOException 文件不存在
     */
    public static void printStreamOut() throws IOException {
        PrintStream print = new PrintStream(new FileOutputStream(new File("d:" + File.separator + "hello.txt")));
        print.println(true);
        print.println("Rollen");
        print.close();
    }

    /**
     * 使用PrintStream进行格式化输出
     *
     * @throws IOException 文件不存在
     */
    public static void printStreamOut1() throws IOException {
        PrintStream print = new PrintStream(new FileOutputStream(new File("d:"
                + File.separator + "hello.txt")));
        String name = "Rollen";
        int age = 20;
        print.printf("姓名：%s. 年龄：%d.", name, age);
        print.close();
    }

}
