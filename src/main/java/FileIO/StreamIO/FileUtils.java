package FileIO.StreamIO;

import java.io.File;

public class FileUtils {
    public static void listDirectory(File dir) throws IllegalAccessException {
        if (!dir.exists()) {
            throw new IllegalAccessException("目录" + dir + "不存在");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录");
        }
//        String[] filename = dir.list();
//        List<String> filenames = Arrays.asList(filename);
//        filenames.forEach(file -> System.out.println(file));
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listDirectory(file);
                } else {
                    System.out.println(file);
                }
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        File file = new File("/Users/Qstar/Documents");
        listDirectory(file);
    }
}
