package algorithm.sort.bubbleSort;

import java.util.Arrays;

/**
 * （1）基本思想：在要排序的一组数中，对当前还未排好序的
 * 范围内的全部数，自上而下对相邻的两个数依次进行比较和调整
 * ，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较
 * 后发现它们的排序与排序要求相反时，就将它们互换。
 */
public class bubbleSort {

    public static void main(String[] args){
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78,
                34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17,
                18, 23, 34, 15, 35, 25, 53, 51};
        Arrays.stream(bubbleSort(a)).forEach(b -> System.out.print(b + " "));
        Arrays.stream(doubleBubbleSort(a)).forEach(value -> System.out.print(value + " "));
    }

    public static int[] bubbleSort(int a[]){
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    public static int[] doubleBubbleSort(int[] a){
        int j;
        int limit = a.length;
        int st = -1;
        while (st < limit) {
            //必须要给st和limit赋值，否则若数组一开始就有序
            st++;
            limit--;
            boolean swapped = false;
            //第一次循环将最大的值放到末尾
            for (j = st; j < limit; j++) {
                if (a[j] > a[j + 1]) {
                    int T = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = T;
                    swapped = true;
                }
            }
            if (!swapped) {
                return a;
            } else {
                swapped = false;
                //第二次循环将最小的值放到了开头
                for (j = limit; --j >= st; ) {
                    if (a[j] > a[j + 1]) {
                        int T = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = T;
                        swapped = true;
                    }
                }
                if (!swapped) {
                    return a;
                }
            }
        }
        return a;
    }
}