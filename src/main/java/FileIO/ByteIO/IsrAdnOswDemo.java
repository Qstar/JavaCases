package FileIO.ByteIO;

import java.io.*;

public class IsrAdnOswDemo {
    public static void main(String[] args) throws IOException{
        FileInputStream in = new FileInputStream("src/FileIO/DocumentsInputFile.txt");
        InputStreamReader isr = new InputStreamReader(in);

        FileOutputStream out = new FileOutputStream("src/FileIO/DocumentsInputFile.txt");
        OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
//        int c;
//        while ((c=isr.read())!=-1){
//            System.out.print((char)c);
//        }

        char[] buffer = new char[8 * 1024];
        int c;
        while ((c = isr.read(buffer, 0, buffer.length)) != -1) {
            String s = new String(buffer, 0, c);
            System.out.println(s);
            osw.write(buffer, 0, 10);
            osw.flush();
        }
        isr.close();
        osw.close();
    }
}
