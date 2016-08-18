package util.implement;


import java.util.Date;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 使用 super.clone() 让Object类负责创建新的对象。
 * 基本类型域都已经被正确地复制了。同样，我们不需要去克隆String和BigInteger等不可变类型。
 * 手动对所有的非基本类型域（对象和数组）进行深度复制（deep copy）。
 * 实现了Cloneable的类，clone()方法永远不要抛CloneNotSupportedException。因此，需要捕获这个异常并忽略它，或者使用不受检异常（unchecked exception）包装它。
 * 不使用Object.clone()方法而是手动地实现clone()方法是可以的也是合法的。
 * 参考：java.lang.Object.clone()、java.lang.Cloneable()。
 */
public class Clone {
    class Values implements Cloneable {
        String abc;
        double foo;
        int[] bars;
        Date hired;

        public Values clone() {
            try {
                Values result = (Values) super.clone();
                result.bars = result.bars.clone();
                result.hired = (Date) result.hired.clone();
                return result;
            } catch (CloneNotSupportedException e) {  // Impossible
                throw new AssertionError(e);
            }
        }
    }
}
