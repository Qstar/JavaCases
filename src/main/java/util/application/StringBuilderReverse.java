package util.application;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 这个方法可能应该加入Java标准库。
 * 参考：java.lang.StringBuilder.reverse()。
 */
public class StringBuilderReverse {
    String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringBuilderReverse().reverse("Hello World"));
    }
}
