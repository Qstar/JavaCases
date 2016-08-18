package io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipStreamCase {
    public static void main(String[] args) {
        try {
//            ZipOutputStreamDemo1();
//            ZipOutputStreamDemo2();
//            ZipFileDemo();
//            ZipFileDemo2();
            ZipFileDemo3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 压缩单个文件
     *
     * @throws IOException 文件不存在
     */
    public static void ZipOutputStreamDemo1() throws IOException {
        File file = new File("d:" + File.separator + "hello.txt");
        File zipFile = new File("d:" + File.separator + "hello.zip");
        InputStream input = new FileInputStream(file);
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(
                zipFile));
        zipOut.putNextEntry(new ZipEntry(file.getName()));
        // 设置注释
        zipOut.setComment("hello");
        int temp;
        while ((temp = input.read()) != -1) {
            zipOut.write(temp);
        }
        input.close();
        zipOut.close();
    }

    /**
     * 一次性压缩多个文件
     *
     * @throws IOException 文件不存在
     */
    public static void ZipOutputStreamDemo2() throws IOException {
        File file = new File("d:" + File.separator + "temp");
        File zipFile = new File("d:" + File.separator + "zipFile.zip");
        InputStream input;
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(
                zipFile));
        zipOut.setComment("hello");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    input = new FileInputStream(file1);
                    zipOut.putNextEntry(new ZipEntry(file.getName()
                            + File.separator + file1.getName()));
                    int temp;
                    while ((temp = input.read()) != -1) {
                        zipOut.write(temp);
                    }
                    input.close();
                }
            }
        }
        zipOut.close();
    }

    /**
     * ZipFile演示
     *
     * @throws IOException 文件不存在
     */
    public static void ZipFileDemo() throws IOException {
        File file = new File("d:" + File.separator + "hello.zip");
        ZipFile zipFile = new ZipFile(file);
        System.out.println("压缩文件的名称为：" + zipFile.getName());
    }

    /**
     * 解压缩文件（压缩文件中只有一个文件的情况）
     *
     * @throws IOException 文件不存在
     */
    public static void ZipFileDemo2() throws IOException {
        File file = new File("d:" + File.separator + "hello.zip");
        File outFile = new File("d:" + File.separator + "unZipFile.txt");
        ZipFile zipFile = new ZipFile(file);
        ZipEntry entry = zipFile.getEntry("hello.txt");
        InputStream input = zipFile.getInputStream(entry);
        OutputStream output = new FileOutputStream(outFile);
        int temp;
        while ((temp = input.read()) != -1) {
            output.write(temp);
        }
        input.close();
        output.close();
    }

    /**
     * 解压缩一个压缩文件中包含多个文件的情况
     *
     * @throws IOException 文件不存在
     */
    public static void ZipFileDemo3() throws IOException {
        File file = new File("d:" + File.separator + "zipFile.zip");
        File outFile;
        ZipFile zipFile = new ZipFile(file);
        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry;
        InputStream input;
        OutputStream output;
        while ((entry = zipInput.getNextEntry()) != null) {
            System.out.println("解压缩" + entry.getName() + "文件");
            outFile = new File("d:" + File.separator + entry.getName());
            if (!outFile.getParentFile().exists()) {
                if (outFile.getParentFile().mkdir()) {
                    System.out.println("创建父文件夹成功");
                }
            }
            if (!outFile.exists()) {
                if (outFile.createNewFile()) {
                    System.out.println("创建文件成功");
                }
            }
            input = zipFile.getInputStream(entry);
            output = new FileOutputStream(outFile);
            int temp;
            while ((temp = input.read()) != -1) {
                output.write(temp);
            }
            input.close();
            output.close();
        }
    }
}
