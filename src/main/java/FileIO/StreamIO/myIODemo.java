package FileIO.StreamIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
FileOutputStream Vs. FileWriter
在Java中有两种写文件的方式：FileOutputStream与FileWriter。
开发人员经常会在它们之间犹豫不决。下面这个例子能帮忙你更好地理解在不同的场景下应该选择何种方案。首先我们来看一下实现：

使用FileOutputStream：

File foutput = new File(file_location_string);
FileOutputStream fos = new FileOutputStream(foutput);
BufferedWriter output = new BufferedWriter(new OutputStreamWriter(fos));
output.write("Buffered Content");


使用FileWriter：

FileWriter fstream = new FileWriter(file_location_string);
BufferedWriter output = new BufferedWriter(fstream);
output.write("Buffered Content");
根据Java的接口规范：

FileOutputStream是用于写入原始字节流比如图片流数据。如果是要写入字符流，则应该考虑使用FileWriter。

这样就很清楚了，写图片应该使用FileOutputStream而写文本则应该选择FileWriter。
 */

public class myIODemo {
    public static void main(String args[]) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("/Users/Qstar/spring/helloJava/src/FileIO/DocumentsInputFile.txt");
            out = new FileOutputStream("/Users/Qstar/spring/helloJava/src/FileIO/DocumentsOutputFile.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}

