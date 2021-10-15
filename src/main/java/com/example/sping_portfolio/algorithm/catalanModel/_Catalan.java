package com.example.sping_portfolio.algorithm.catalanModel;

import com.example.sping_portfolio.consoleUI.ConsoleMethods;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
// import lombok.Getter;

/*
 _Fibonacci class contains generalized logic to capture and analyze a Fibonacci sequence.
 _Fibonacci is an "abstract" class, meaning it can't be initialized directly
 The "_" in name is used to push this "Parent" Class to top of package file listing.
 */
// this will enable standard Getters on attributes in Class in form "getName" where "name" is attribute
public abstract class _Catalan {
    int size;
    String name;
    int hashID;
    Duration timeElapsed;
    ArrayList<Long> list;
    HashMap<Integer, Object> hash;

    /*
     Zero parameter constructor uses Telescoping technique to allow setting of the required value nth
     @param: none
     */
    public _Catalan() {
        this( 20);
    }

    /*
     Construct the nth catalan number
     @param: nth number, the value is constrained to 92 because of overflow in a long
     */
    public _Catalan(int nth) {
        this.size = nth;
        this.list = new ArrayList<>();
        this.hashID = 0;
        this.hash = new HashMap<>();
        //initialize catalan and time algorithm
        Instant start = Instant.now();  // time capture -- start
        this.init();
        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
    }

    /*
     Method is abstract as init() requires extender to define their own Fibonacci algorithm
     Method is protected as it is only authorized to someone who extends the class
     */
    protected abstract void init();

    /*
     Number is added to Fibonacci sequence, current state of "list" is added to hash for hashID "num"
     */
    public void setData(long num) {
        list.add(num);
        hash.put(this.hashID++, list.clone());
    }

    /*
     Custom Getter for timeElapsed in init process, timeElapsed.getNano() is part of Duration class
     */
    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }

    /*
     Custom Getter to return last element in Catalan sequence
     */
    public long getNth() {
        return list.get(size - 1);
    }

    /*
     Custom Getter to return last Catalan sequence in HashMap
     */
    public Object getNthSeq(int i) {
        return hash.get(i);
    }

    /*
     Console/Terminal supported print method
     */
    public void print() {
        ConsoleMethods.println("Init method = " + this.name);
        ConsoleMethods.println("Init time = " + this.getTimeElapsed());
        ConsoleMethods.println("Fibonacci Number " + this.size + " = " + this.getNth());
        /* ConsoleMethods.println("Fibonacci List = " + this.getList());
        ConsoleMethods.println("Fibonacci Hashmap = " + this.getHash()); */
        for (int i=0 ; i<this.size; i++ ) {
            ConsoleMethods.println("Fibonacci Sequence " + (i+1) + " = " + this.getNthSeq(i));
        }
    }

    /*
    Tester class method.  This calls "main" class of each of the extended classes in the package
     */
    public static void main(String[] args) {
        CatFor.main(null);
        CatRecurse.main(null);
        CatStream.main(null);
        CatWhile.main(null);
    }
}