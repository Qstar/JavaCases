package util.preventiveDetection;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 不要认为输入的数值都是正数、足够小的数等等。要显式地检测这些条件。
 * 一个设计良好的函数应该对所有可能性的输入值都能够正确地执行。要确保所有的情况都考虑到了并且不会产生错误的输出（比如溢出）。
 */
public class Number {
    public static void main(String[] args) {
        System.out.println(new Number().factorial(-0));
    }

    int factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Undefined");
        else if (n >= 13)
            throw new ArithmeticException("Result overflow");
        else if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }
}
