package concurrentProgramming.JUC;

//可见性
public class NoVisiability {
    private static class ReadThread extends Thread {
        private boolean ready;
        private int number;

        public void run() {
            while (!ready) {
                number++;
            }
            System.out.println(ready + " " + number);
        }

        public void readyOn() {
            this.ready = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadThread readThread = new ReadThread();
        readThread.start();
        Thread.sleep(2000);
        readThread.readyOn();
        System.out.println(readThread.ready);
    }
}