package io;

import java.io.File;

public class IsDir {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator;
        File f = new File(fileName);
        if (f.isDirectory()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
