package com.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class RouterManager {
    
    public static PriorityBlockingQueue<Package> queue;
    
    static int PACKAGES_AMOUNT = 6;
    static String[] packageHeaders = new String[PACKAGES_AMOUNT];
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        
        prepareHeaders();
        queue = new PriorityBlockingQueue<Package>();
        
        for ( int i = 0; i < PACKAGES_AMOUNT; i++ ) {
            executor.execute(new Package(packageHeaders[i]));
        }
        
        while ( true ) {
            if ( !queue.isEmpty() ) {
                System.out.println("ARRIVED: " + queue.poll().getInfo());
            }
        }
    }
    
    private static void prepareHeaders() {
        packageHeaders[0] = "user: want to eat";
        packageHeaders[1] = "user: want to sleep";
        packageHeaders[2] = "user: want to be the luckiest guy in the world";
        packageHeaders[3] = "system: feed";
        packageHeaders[4] = "system: kill";
        packageHeaders[5] = "system: update all humans around the world during this night";
    }
}
