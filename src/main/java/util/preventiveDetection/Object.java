package util.preventiveDetection;

import java.util.List;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 不要认为对象参数不会为空（null）。要显式地检测这个条件。
 */
public class Object {
    int findIndex(List<String> list, String target) {
        if (list == null || target == null)
            throw new NullPointerException();
        return 0;
    }
}
