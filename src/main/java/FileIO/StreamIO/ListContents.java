package FileIO.StreamIO;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ListContents {
    public static void main(String[] args) {
        File file = new File("/Users/Qstar/Documents");
        String[] files = file.list();

        System.out.println("Listing contents of " + file.getPath());
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
        System.out.println();
        System.out.println("Lambda--------------------------------------");
        System.out.println("Listing contents of " + file.getPath());
        List<String> LambdaFiles = Arrays.asList(files);

        LambdaFiles.forEach((LambdaFile) -> System.out.println(LambdaFile));

    }
}