package com.example.sping_portfolio.algorithm.pellModel;

import com.example.sping_portfolio.consoleUI.ConsoleMethods;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

import lombok.Getter;

/*
 _Fibonacci class contains generalized logic to capture and analyze a Fibonacci sequence.
 _Fibonacci is an "abstract" class, meaning it can't be initialized directly
 The "_" in name is used to push this "Parent" Class to top of package file listing.
 */
 // this will enable standard Getters on attributes in Class in form "getName" where "name" is attribute
public abstract class _Pell {
    int size;

    public String getName() {
        return name;
    }
    String name;
    int hashID;
    Duration timeElapsed;
    ArrayList<Long> list;
    HashMap<Integer, Object> hash;

    /*
     Zero parameter constructor uses Telescoping technique to allow setting of the required value nth
     @param: none
     */
    public _Pell() {
        this( 20);
    }

    public _Pell(int nth) {
        this.size = nth;
        this.list = new ArrayList<>();
        this.hashID = 0;
        this.hash = new HashMap<>();
        //initialize fibonacci and time algorithm
        Instant start = Instant.now();  // time capture -- start
        this.init();
       try {
           Thread.sleep(1);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
    }

    protected abstract void init();

    public void setData(long num) {
        list.add(num);
        hash.put(this.hashID++, list.clone());
    }


//    public int getTimeElapsed() {
//        return timeElapsed.getNano();
//    }
    public long getTimeElapsed() {
        return timeElapsed.toNanos();
    }

    public long getNth() {
        return list.get(size - 1);
    }

    public Object getNthSeq(int i) {
        return hash.get(i);
    }

    public ArrayList<Long> getList() {
        return list;
    }

    public HashMap<Integer, Object> getHash() {
        return hash;
    }

    /*
     Console/Terminal supported print method
     */
    public void print() {
        ConsoleMethods.println("Init method = " + this.name);
        ConsoleMethods.println("Init time = " + this.getTimeElapsed());
        ConsoleMethods.println("Pell Number " + this.size + " = " + this.getNth());
        ConsoleMethods.println("Pell List = " + this.getList());
        ConsoleMethods.println("Pell Hashmap = " + this.getHash());
        for (int i=0 ; i<this.size; i++ ) {
            ConsoleMethods.println("Pell Sequence " + (i+1) + " = " + this.getNthSeq(i));
        }
    }

    public static void main(String[] args) {
        PellFor.main(null);
        PellRecurse.main(null);
        PellStream.main(null);
        PellWhile.main(null);
    }
}