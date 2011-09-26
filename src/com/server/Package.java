package com.server;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Package implements Comparable<Package>, Runnable {
    private final String info;
    private final int size;
    
    public Package(String information) {
        info = information;
        size = info.length();
    }
    
    public void run() {
        Random r = new Random();
        TimeUnit t = TimeUnit.MILLISECONDS;
        
        try { // simulation of delays in pushing packages
            t.sleep(r.nextInt() % 10000);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        // putting into a queue
        RouterManager.queue.add(this);
    }
    
    public int compareTo(Package other) {
        if ( other.size > size )
            return -1;
        
        if ( size > other.size )
            return 1;
        
        return 0;
    }
    
    public String getInfo() {
        return "size(" + size + "): " + info;
    }
}
