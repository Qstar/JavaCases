package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerCase {
    public static void main(String[] args) {
//        readFromKeyboard();
        readFromFile();
    }

    /**
     * Scanner的小例子，从键盘读数据
     */
    public static void readFromKeyboard() {
        Scanner sca = new Scanner(System.in);
        // 读一个整数
        int temp = sca.nextInt();
        System.out.println(temp);
        //读取浮点数
        float flo = sca.nextFloat();
        System.out.println(flo);
        //读取字符
        //...等等的，都是一些太基础的，就不师范了。
    }

    /**
     * Scanner的小例子，从文件中读内容
     */
    public static void readFromFile() {
        File file = new File("d:" + File.separator + "hello.txt");
        Scanner sca = null;
        try {
            sca = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str = null;
        if (sca != null) {
            str = sca.next();
        }
        System.out.println("从文件中读取的内容是：" + str);
    }
}
