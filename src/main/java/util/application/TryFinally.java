package util.application;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.locks.Lock;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 如果try之前的语句运行失败并且抛出异常，
 * 那么finally语句块就不会执行。但无论怎样，在这个例子里不用担心资源的释放。
 * <p>
 * 如果try语句块里面的语句抛出异常，
 * 那么程序的运行就会跳到finally语句块里执行尽可能多的语句，
 * 然后跳出这个方法（除非这个方法还有另一个外围的finally语句块）。
 */
public class TryFinally {
    //I/O流例子：
    void writeStuff() throws IOException {
        OutputStream out = new FileOutputStream("");
        try {
            out.write("".getBytes());
        } finally {
            out.close();
        }
    }

    //锁例子：
    void doWithLock(Lock lock) {
        lock.lock();
        //lock.acquire();
        try {
            //TODO
        } finally {
            lock.unlock();
            //lock.release();
        }
    }
}
