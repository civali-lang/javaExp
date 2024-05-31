import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// 测试类，继承Thread类
class TestThread extends Thread {
    private final char start;
    private final char end;

    public TestThread(char start, char end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (char c = start; c <= end; c++) {
            System.out.print(c + " ");
            // 让其他线程有机会执行
            Thread.yield();
        }
    }
}

// 测试类，实现Runnable接口
class TestRunnable implements Runnable {
    private final String numbers;

    public TestRunnable(String numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int i = 0; i < numbers.length(); i++) {
            System.out.print(numbers.charAt(i) + " ");
            // 让其他线程有机会执行
            Thread.yield();
        }
    }
}

public class ThreadPoolTest {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 创建并启动线程一，打印字母A-Z
        TestThread testThread = new TestThread('A', 'Z');
        executorService.execute(testThread);

        // 创建并启动线程二，打印数字0-9
        TestRunnable testRunnable = new TestRunnable("0123456789");
        executorService.submit(testRunnable);

        // 主线程打印希腊字母
        String greekAlphabets = "ΑαΒβΓγΔδΕεΖζΗηΘθΙιΚκΛλΜμΝξξΟοΠπΡρΣσςΤτΥυΦφΧχΨψΩω";
        for (int i = 0; i < greekAlphabets.length(); i++) {
            System.out.print(greekAlphabets.charAt(i) + " ");
            // 主线程每次打印后让出CPU，使得其他线程有机会执行
            Thread.yield();
        }

        // 关闭线程池
        executorService.shutdown();

        // 等待线程池中的所有任务完成
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("线程池中仍有未完成的任务");
            }
        } catch (InterruptedException e) {
            System.out.println("等待线程池关闭时发生中断");
        }
    }
}