package me.ramonper.asyncexample.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public interface Asynchronous <P> {
    ExecutorService threadPool = Executors.newFixedThreadPool(3);
    public void sendAsync(P param);
}
