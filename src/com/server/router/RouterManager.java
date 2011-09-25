package com.server.router;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.server.packages.Package;

public class RouterManager {
    
    public static void main(String[] args) {
        Package pack1 = new Package("small task 1");
        Package pack2 = new Package("small task 2");
        Package pack3 = new Package("very big and huge task 1");
        
        System.out.println("Starting Executor");
        ExecutorService threadExecutor = Executors.newCachedThreadPool();
        
        // start threads and place in runnable state
        threadExecutor.execute(pack1);
        threadExecutor.execute(pack2);
        threadExecutor.execute(pack3);
        
        // shut down worker threads when their tasks complete
        threadExecutor.shutdown();
        System.out.println("main ends.\n");
    }
}
