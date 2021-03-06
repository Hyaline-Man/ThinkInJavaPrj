package com.zh.concurrent;


import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by zh on 2017-01-21.
 */
public class ActiveObjectDemo {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Random random = new Random(47);
    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(factor));
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }
    public Future<Integer> calculateInt(final int x, final int y) {
        return executorService.submit(()->{
            System.out.println("starting " + x + " + " + y);
            pause(500);
            return x + y;
        });
    }
    public Future<Float> calculateFloat(final float x, final float y) {
        return executorService.submit(()->{
            System.out.println("starting " + x + " + " + y);
            pause(2000);
            return x + y;
        });
    }
    public void shutdown() {
        executorService.shutdown();
    }
    public static void main(String[] args) {
        ActiveObjectDemo d1 = new ActiveObjectDemo();
        List<Future<?>> results = new CopyOnWriteArrayList<>();
        for (float f = 0.0f; f < 1.0f; f += 0.2f)
            results.add(d1.calculateFloat(f, f));
        for (int i = 0; i < 5; i++)
            results.add(d1.calculateInt(i, i));
        System.out.println("All asynch calls made");
        while (results.size() > 0) {
            for(Future<?> f : results) {
                if(f.isDone()) {
                    try {
                        System.out.println(f.get());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    results.remove(f);
                }
            }
        }
        d1.shutdown();
    }
}
