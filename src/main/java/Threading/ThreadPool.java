package Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
    List<ThreadPoolThread> runnables = new ArrayList<ThreadPoolThread>();
    BlockingQueue<Runnable> queue;
    public ThreadPool(int numberOfThreads, BlockingQueue queue){
        this.queue = queue;
        for (int i=0; i<numberOfThreads;i++){
            runnables.add(new ThreadPoolThread(queue));
        }
        for(ThreadPoolThread runnable:runnables){
            new Thread(runnable).start();
        }
    }

    public void execute(Runnable runnable){
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
