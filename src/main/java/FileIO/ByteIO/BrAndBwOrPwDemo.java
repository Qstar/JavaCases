package FileIO.ByteIO;

import java.io.*;

public class BrAndBwOrPwDemo {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("src/FileIO/demo/out.dat")));
//        BufferedWriter bw = new BufferedWriter(
//                new OutputStreamWriter(
//                        new FileOutputStream("src/FileIO/demo/out3.dat")));
        PrintWriter pw = new PrintWriter("src/FileIO/demo/out4.dat");
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
//            bw.write(line);
//            bw.newLine();
//            bw.flush();
            pw.println(line);
            pw.flush();
        }
        br.close();
//        bw.close();
        pw.close();
    }
}
