package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class Client {
    public static void main(String[] args){

        System.out.println("Hello World!");
        Arrays.stream(createDate(10)).forEach(value -> System.out.print(value + " "));
    }

    private static int[] createDate(int count){
        /**
         * 无重复数组
         */
        int[] data = new int[count];
        Random rand = new Random();
        boolean[] bool = new boolean[100];
        int num;
        for (int i = 0; i < count; i++) {
            do {
                // 如果产生的数相同继续循环
                num = rand.nextInt(100);
            } while (bool[num]);
            bool[num] = true;
            /*   list.add(num);*///list 列表
            data[i] = num;
        }
        return data;
    }
}
