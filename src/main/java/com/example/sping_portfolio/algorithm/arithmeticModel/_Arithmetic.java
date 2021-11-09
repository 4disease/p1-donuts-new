package com.example.sping_portfolio.algorithm.arithmeticModel;

import com.example.sping_portfolio.minilabs.ConsoleMethods;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class _Arithmetic {
    int size;

    public String getName() {
        return name;
    }

    String name;
    int hashID;
    Duration timeElapsed;
    ArrayList<Long> list;
    HashMap<Integer, Object> hash;

    public _Arithmetic(int nth) {
        this.size = nth;
        this.list = new ArrayList<>();
        this.hashID = 0;
        this.hash = new HashMap<>();
        //initialize fibonacci and time algorithm
        Instant start = Instant.now();  // time capture -- start
        this.init();
        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
    }

    protected abstract void init();

    public void setData(long num) {
        list.add(num);
        hash.put(this.hashID++, list.clone());
    }

    public int getTimeElapsed() {
        return timeElapsed.getNano();
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



    public void print() {
        ConsoleMethods.println("Init method = " + this.name);
        ConsoleMethods.println("Init time = " + this.getTimeElapsed());
        ConsoleMethods.println("Arithmetic Number " + this.size + " = " + this.getNth());
        ConsoleMethods.println("Arithmetic List = " + this.getList());
        ConsoleMethods.println("Arithmetic Hashmap = " + this.getHash());
        for (int i=0 ; i<this.size; i++ ) {
            ConsoleMethods.println("Arithmetic Sequence " + (i+1) + " = " + this.getNthSeq(i));
        }
    }

    public static void main(String[] args) {
        ArithmeticFor.main(null);
        ArithmeticRecurse.main(null);
        ArithmeticStream.main(null);
        ArithmeticWhile.main(null);
    }
}