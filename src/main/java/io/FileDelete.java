package io;

import java.io.File;

/**
 * 删除一个文件
 */
public class FileDelete {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        if (f.exists()) {
            if (f.delete()) {
                System.out.println("File Deleted");
            }
        } else {
            System.out.println("文件不存在");
        }
    }
}
