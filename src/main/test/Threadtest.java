import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/4/6 0006.
 */
public class Threadtest {
    public static void main(String []args){
        LinkedList<String> list = new LinkedList<String>();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        list.add("a");
        list.add("a");
        list.add("a");
        Thread1 t1 = new Thread1(list, "a", lock, condition);
        Thread thread1 = new Thread(t1);

        thread1.start();

        t1.test();


    }
}


class Thread1 implements Runnable {
    Queue<String> queue;
    String myNum;
    Lock lock;
    Condition condition;

    public Thread1(Queue<String> queue, String myNum, Lock lock, Condition condition) {
        this.queue = queue;
        this.myNum = myNum;
        this.lock = lock;
        this.condition = condition;

    }
    public void test(){
        System.out.println("aaa");
    }
    public void run() {
        lock.lock();
        try {
            while (true) {
                if (queue.peek().equals(myNum)) {
                    System.out.println(Thread.currentThread().getName());

                    queue.poll();
                    break;
                }

            }
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
