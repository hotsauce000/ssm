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
        list.add("b");
        list.add("c");
        Thread1 t1 = new Thread1(list, "a", lock, condition);
        Thread2 t2 = new Thread2(list, "b", lock, condition);
        Thread3 t3  = new Thread3(list, "c", lock, condition);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);


        thread3.start();
        thread2.start();
        thread1.start();

    }
    }
    class Thread1 extends demo implements Runnable{
        public Thread1 (Queue<String> queue, String myNum, Lock lock, Condition condition)
        {
            this.queue = queue;
            this.myNum = myNum;
            this.lock = lock;
            this.condition = condition;

        }

    public void run() {
        lock.lock();
       try{
           while (true) {
               if (queue.peek().equals(myNum)) {
                   System.out.println(Thread.currentThread().getName());
                   condition.signalAll();
                   queue.poll();
                   break;
               }
               condition.await();
           }
       }catch (Exception e ){
           e.printStackTrace();
       }finally {
           lock.unlock();
       }



    }
}

class Thread2 extends  demo implements Runnable {
    public Thread2 (Queue<String> queue, String myNum, Lock lock, Condition condition)
    {
        this.queue = queue;
        this.myNum = myNum;
        this.lock = lock;
        this.condition = condition;

    }

    public void run() {
        lock.lock();
        try{
            while (true) {
                if (queue.peek().equals(myNum)) {
                    System.out.println(Thread.currentThread().getName());
                    condition.signalAll();
                    queue.poll();
                    break;
                }
                condition.await();
            }
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
       }

    }


        class Thread3 extends demo implements Runnable {
            public Thread3 (Queue<String> queue, String myNum, Lock lock, Condition condition)
            {
                this.queue = queue;
                this.myNum = myNum;
                this.lock = lock;
                this.condition = condition;

    }

    public  void run() {
        lock.lock();
        try{
            while (true) {
                if (queue.peek().equals(myNum)) {
                    System.out.println(Thread.currentThread().getName());
                    condition.signalAll();
                    queue.poll();
                    break;
                }
                condition.await();
            }
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
class demo{
    Queue<String> queue;
    String myNum;
    Lock lock;
    Condition condition;


}




