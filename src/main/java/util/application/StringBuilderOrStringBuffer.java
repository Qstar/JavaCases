package util.application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 不要像这样使用重复的字符串连接：s += item ，因为它的时间效率是O(n^2)。
 * 使用StringBuilder或者StringBuffer时，可以使用append()方法添加文本和使用toString()方法去获取连接起来的整个文本。
 * 优先使用StringBuilder，因为它更快。StringBuffer的所有方法都是同步的，而你通常不需要同步的方法。
 * 参考java.lang.StringBuilder、java.lang.StringBuffer。
 */
public class StringBuilderOrStringBuffer {
    // join(["a", "b", "c"]) -> "a and b and c"
    String join(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String s : strs) {
            if (first) first = false;
            else sb.append(" and ");
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> toJoin = new ArrayList<>();
        toJoin.add("a");
        toJoin.add("b");
        toJoin.add("c");
        System.out.println(new StringBuilderOrStringBuffer().join(toJoin));
    }
}
