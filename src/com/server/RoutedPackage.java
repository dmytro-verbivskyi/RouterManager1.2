package com.server;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RoutedPackage implements Runnable {
    static public int count = 0;
    private int id = count++;
    private String info;
    
    public RoutedPackage(String information) {
        info = information;
    }
    
    public void run() {
        while ( true ) {
            Random r = new Random();
            TimeUnit t = TimeUnit.MILLISECONDS;
            
            try {
                t.sleep(r.nextInt() % 10000);
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
            RouterManager.queue.add(new Package(info));
        }
    }
}