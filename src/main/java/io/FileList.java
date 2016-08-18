package io;

import java.io.File;

public class FileList {
    public static void main(String[] args) {
        fileList();
        fileListCompletePath();
    }

    /**
     * 使用list列出指定目录的全部文件
     */
    private static void fileList() {
        String fileName = "D:" + File.separator;
        File f = new File(fileName);
        String[] str = f.list();
        if (str != null) {
            for (String aStr : str) {
                System.out.print(aStr + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 使用listFiles列出指定目录的全部文件
     * listFiles输出的是完整路径
     */
    private static void fileListCompletePath() {
        String fileName = "D:" + File.separator;
        File f = new File(fileName);
        File[] str = f.listFiles();
        if (str != null) {
            for (File aStr : str) {
                System.out.print(aStr + "\t");
            }
            System.out.println();
        }
    }
}
