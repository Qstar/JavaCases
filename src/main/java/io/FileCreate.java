package io;

import java.io.File;

/**
 * 创建一个新文件
 */
public class FileCreate {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        try {
            if (f.createNewFile()) {
                System.out.println("File Created");
                System.out.println(File.separator);
                System.out.println(File.pathSeparator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
