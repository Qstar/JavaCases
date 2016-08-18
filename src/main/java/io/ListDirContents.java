package io;

import java.io.File;

public class ListDirContents {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator;
        File f = new File(fileName);
        print(f);
    }

    /**
     * 列出指定目录的全部内容
     */
    public static void print(File f) {
        if (f != null) {
            if (f.isDirectory()) {
                File[] fileArray = f.listFiles();
                if (fileArray != null) {
                    for (File aFileArray : fileArray) {
                        //递归调用
                        print(aFileArray);
                    }
                }
            } else {
                System.out.println(f);
            }
        }
    }
}
