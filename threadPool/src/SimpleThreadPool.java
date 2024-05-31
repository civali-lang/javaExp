import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleThreadPool {

    private final int poolSize;
    private final ExecutorService executor;
    private final List<Worker> workers;
    private volatile boolean isShutdown = false;

    public SimpleThreadPool(int poolSize) {
        this.poolSize = poolSize;
        this.workers = new ArrayList<>(poolSize);
        this.executor = new ThreadPoolExecutor(
                poolSize,
                poolSize,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    public void start() {
        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            executor.execute(worker);
        }
    }

    public void submit(Runnable task) {
        if (!isShutdown) {
            executor.execute(task);
        } else {
            throw new IllegalStateException("线程池已经关闭");
        }
    }

    public void shutdown() {
        isShutdown = true;
        executor.shutdown();
    }

    private class Worker implements Runnable {
        @Override
        public void run() {
            while (!isShutdown) {
                try {
                    // 从任务队列中获取任务
                    Runnable task = ((ThreadPoolExecutor) executor).getQueue().poll(1, TimeUnit.SECONDS);
                    if (task != null) {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        SimpleThreadPool pool = new SimpleThreadPool(4); // 创建具有4个线程的线程池
        pool.start(); // 启动线程池

        // 提交任务到线程池
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            pool.submit(() -> System.out.println("执行任务 " + finalI + " 由线程 " + Thread.currentThread().getName()));
        }

        // 等待所有任务执行完毕
        try {
            pool.executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pool.shutdown(); // 关闭线程池
    }
}