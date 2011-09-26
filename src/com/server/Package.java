package com.server;

public class Package implements Comparable<Package> {
    private final String info;
    private final int size;
    
    public Package(String information) {
        info = information;
        size = info.length();
    }
    
    public int compareTo(Package f) {
        if ( f.size > size )
            return -1;
        
        if ( size > f.size )
            return 1;
        
        return 0;
    }
    
    public String getInfo() {
        return info + "; size: " + size;
    }
}
