package FileIO.StreamIO;

import java.io.*;

/*
    单字节不适合大文件
 */

public class IOUtil {
    public static void printHex(String finaName) throws IOException {
        FileInputStream in = new FileInputStream(finaName);
        int b;
        int i = 1;
        while ((b = in.read()) != -1) {
            if (b <= 0xf) {
                //单位数前面补0
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + " ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        in.close();
    }

    public static void printHExByByteArray(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[20 * 1024];
        //从in中批量读取字节,从0个位置开始放,最多放buf.length个
//        int bytes = in.read(buf, 0, buf.length);//一次性读完
//        int j = 1;
//        for (int i = 0; i < bytes; i++) {
//            if (buf[i] <= 0xf) {
//                System.out.print("0");
//            }
//            System.out.print(Integer.toHexString(buf[i]&0xff)+" ");
//            if (j++ % 10 == 0) {
//                System.out.println();
//            }
//        }
        int bytes = 0;
        while ((bytes = in.read(buf, 0, buf.length)) != -1) {
            for (int i = 0; i < bytes; i++) {
                System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
            }
        }
        in.close();
    }

    public static void copyFile(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件: " + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        byte[] buf = new byte[8 * 1024];
        int b;
        while ((b = in.read(buf, -0, buf.length)) != -1) {
            out.write(buf, 0, b);
            out.flush();
        }
        out.close();
    }

    public static void copyFileByBuffer(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件: " + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(destFile));
        int c;
        while ((c = bis.read()) != -1) {
            bos.write(c);
            bos.flush();
        }
        bis.close();
        bos.close();
    }

    public static void main(String[] args) {
        try {
            printHex("src/FileIO/FileUtils.java");
            System.out.println();
            System.out.println();
            printHExByByteArray("src/FileIO/FileUtils.java");
            copyFile(new File("src/FileIO/DocumentsInputFile.txt"),
                    new File("src/FileIO/demo/DocumentsOutputFile.txt"));
            long start = System.currentTimeMillis();
            copyFileByBuffer(new File("src/FileIO/DocumentsInputFile.txt"),
                    new File("src/FileIO/demo/OutputFile.txt"));
            long end = System.currentTimeMillis();
            System.out.println();
            System.out.println(end - start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
