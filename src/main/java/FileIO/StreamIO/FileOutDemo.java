package FileIO.StreamIO;


import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream out = new FileOutputStream("src/FileIO/demo/out.dat");
        out.write('A');
        out.write('B');
        int a = 10;
        out.write(a >>> 24);
        out.write(a >>> 16);
        out.write(a >>> 8);
        out.write(a);

        byte[] gbk = "中国".getBytes("gbk");
        out.write(gbk);

        out.close();

        IOUtil.printHex("src/FileIO/demo/out.dat");
    }
}
