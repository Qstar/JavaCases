package util.application;

import java.util.Iterator;
import java.util.List;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * remove()方法作用在next()方法最近返回的条目上。每个条目只能使用一次remove()方法。
 * 参考：java.util.Iterator.remove()。
 */
public class IteratorRemove {
    void filter(List<String> list) {
        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            String item = iter.next();
            if (item.isEmpty())
                iter.remove();
        }
    }
}
