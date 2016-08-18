package util.implement;

import java.util.Arrays;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 当x和y两个对象具有x.equals(y) == true ，你必须要确保x.hashCode() == y.hashCode()。
 * 根据逆反命题，如果x.hashCode() != y.hashCode()，那么x.equals(y) == false 必定成立。
 * 你不需要保证，当x.equals(y) == false时，x.hashCode() != y.hashCode()。但是，如果你可以尽可能地使它成立的话，这会提高哈希表的性能。
 * hashCode()最简单的合法实现就是简单地return 0；虽然这个实现是正确的，但是这会导致HashMap这些数据结构运行得很慢。
 * 参考：java.lang.Object.hashCode()。
 */
public class HashCode {
    class Person {
        String a;
        Object b;
        byte c;
        int[] d;

        public int hashCode() {
            return a.hashCode() + b.hashCode() + c + Arrays.hashCode(d);
        }

        //TODO
        public boolean equals(Object o) {
            return false;
        }
    }
}
