package com.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class RouterManager {
    
    public static PriorityBlockingQueue<Package> queue;
    
    static int PACKAGES_AMOUNT = 6;
    static String[] packageHeaders = new String[PACKAGES_AMOUNT];
    
    public RouterManager() {
        queue = new PriorityBlockingQueue<Package>();
    }
    
    private void routePackage(ExecutorService executor, Package p) {
        executor.execute(p);
    }
    
    private static void prepareHeaders() {
        packageHeaders[0] = "user: want to eat";
        packageHeaders[1] = "user: want to sleep";
        packageHeaders[2] = "user: want to be the luckiest guy in the world";
        packageHeaders[3] = "system: feed";
        packageHeaders[4] = "system: kill";
        packageHeaders[5] = "system: update all humans around the world during this night";
    }
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        RouterManager router = new RouterManager();
        // comment added from github
        
        prepareHeaders();
        
        for ( int i = 0; i < PACKAGES_AMOUNT; i++ ) {
            router.routePackage(executor, new Package(packageHeaders[i]));
        }
        executor.shutdown();
        
        int arrived = 0;
        
        while ( arrived <= PACKAGES_AMOUNT - 1 ) {
            if ( !queue.isEmpty() ) {
                System.out.println(++arrived + "| ARRIVED: "
                        + queue.poll().getInfo());
            }
        }
    }
}
