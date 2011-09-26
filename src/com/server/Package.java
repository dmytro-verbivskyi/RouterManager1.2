package com.server;

import java.util.Random;

public class Package implements Runnable {
    private final int id;
    private final String info;
    private final int size;
    
    private final int sleepTime;
    private final static Random generator = new Random();
    
    public Package(String information) {
        id = 1;
        info = information;
        size = info.length();
        sleepTime = generator.nextInt(5000); // milliseconds
    }
    
    public void run() {
        try {
            System.out.printf("info: %s; sleepTime: %d ms.\n", info, sleepTime);
            Thread.sleep(sleepTime);
        } catch ( InterruptedException exception ) {
            System.out.printf("%s %s\n", info, "terminated & interrupted");
        }
        System.out.printf("id: %d; %s ( ARRIVED )\n", id, info);
    }
}
