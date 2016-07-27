package Loop;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class LoopUsage {
    public static void main(String[] args) {
        /* 建立一个数组 */
        int[] integers = {1, 2, 3, 4};
        /* 开始遍历 */
        for (int j = 0; j < integers.length; j++) {
            int i = integers[j];
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        
        /* 建立一个Collection */
        String[] strings = {"A", "B", "C", "D"};
        Collection stringList = Arrays.asList(strings);
        /* 开始遍历 */
        for (Iterator itr = stringList.iterator(); itr.hasNext(); ) {
            Object str = itr.next();
            System.out.print(str + "\t");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        
        /* 建立一个数组 */
        int[] integers1 = {1, 2, 3, 4};

        /* 开始遍历 */
        for (int i : integers1) {
            System.out.print(i + "\t"); /* 依次输出“1”、“2”、“3”、“4” */
        }
        System.out.println();
        System.out.println("---------------------------------------------");

        /* 建立一个数组 */
        int[] integers2 = {1, 2, 3, 4};

        /* 开始遍历 */
        for (int 变量名甲 = 0; 变量名甲 < integers2.length; 变量名甲++) {
            System.out.print(integers[变量名甲] + "\t"); /* 依次输出“1”、“2”、“3”、“4” */
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        
        /* 建立一个Collection */
        String[] strings1 = {"A", "B", "C", "D"};
        Collection list1 = Arrays.asList(strings1);

        /* 开始遍历 */
        for (Object str : list1) {
            System.out.print(str + "\t"); /* 依次输出“A”、“B”、“C”、“D” */
        }
        System.out.println();
        System.out.println("---------------------------------------------");

        /* 建立一个Collection */
        String[] strings2 = {"A", "B", "C", "D"};
        Collection stringList2 = Arrays.asList(strings2);

        /* 开始遍历 */
        for (Iterator 变量名乙 = stringList2.iterator(); 变量名乙.hasNext(); ) {
            Object str = 变量名乙.next();
            System.out.print(str + "\t"); /* 依次输出“A”、“B”、“C”、“D” */
        }
        System.out.println();
        System.out.println("---------------------------------------------");
    }
}
