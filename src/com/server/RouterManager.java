package com.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class RouterManager {
    
    public static PriorityBlockingQueue<Package> queue;
    
    static int PACKAGES_AMOUNT = 4;
    static String[] packageHeaders = new String[PACKAGES_AMOUNT];
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        
        prepareHeaders();
        queue = new PriorityBlockingQueue<Package>();
        
        for ( int i = 0; i < PACKAGES_AMOUNT; i++ ) {
            executor.execute(new RoutedPackage(packageHeaders[i]));
        }
        
        while ( true ) {
            if ( !queue.isEmpty() ) {
                System.out.println("ARRIVED: " + queue.poll().getInfo());
            }
        }
    }
    
    private static void prepareHeaders() {
        packageHeaders[0] = "small header 1";
        packageHeaders[1] = "small header 22";
        packageHeaders[2] = "small header 333";
        packageHeaders[3] = "small header 4444";
    }
}
