package FileIO.StreamIO;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosDemo {
    public static void main(String[] args) throws IOException {
        String file = "src/FileIO/demo/dos.dat";
        DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(file));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10l);
        dos.writeDouble(10.5);
        //采用utf-8编码写出
        dos.writeUTF("中国");
        //采用utef-16be 编码写出
        dos.writeChars("中国");

        IOUtil.printHex(file);
    }
}
