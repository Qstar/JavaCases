package io;

import java.io.File;

/**
 * 创建一个文件夹
 */
public class FolderCreate {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator + "hello";
        File f = new File(fileName);
        if (f.mkdir()) {
            System.out.println("Folder Created");
        }
    }
}
