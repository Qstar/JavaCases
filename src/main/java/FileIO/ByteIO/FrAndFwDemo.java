package FileIO.ByteIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {
    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("src/FileIO/demo/out.dat");
        FileWriter fw = new FileWriter("src/FileIO/demo/out2.dat", true);
        char[] buffer = new char[2056];
        int c;
        while ((c = fr.read(buffer, 0, buffer.length)) != -1) {
            fw.write(buffer, 0, c);
            fw.flush();
        }
        fr.close();
        fw.close();
    }
}
