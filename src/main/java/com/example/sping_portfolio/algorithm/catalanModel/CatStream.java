package com.example.sping_portfolio.algorithm.catalanModel;

import java.util.stream.Stream;

public class CatStream extends com.example.sping_portfolio.algorithm.catalanModel._Catalan {
    public CatStream() {
        super();
    }
    public CatStream(int nth) {
        super(nth);
    }

    /*
    Abstract Polymorphic "init()" method using Stream and Lambda expressions
    */
    @Override
    protected void init() {
        super.name = "Stream";
        int n = 2;
        // Stream iterates using lambda "->" syntax unil ".limit" is reached
        // Streams and Lambda have been added to more recent versions of Java, this will NOT be on AP Test
        // Streams are prevalent in Big Data, in this example it seems to perform the worst
        Stream.iterate(new long[]{1, 1}, f -> new long[]{f[1], f[1] * 2 * n * (2 * n - 1) / (n * n + n)})
                .limit(super.size)
            .forEach(f -> super.setData(f[0]));
    }

    /*
    Class method "main" with purpose of testing CatStream
     */
    public static void main(String[] args) {
        com.example.sping_portfolio.algorithm.catalanModel._Catalan catalan = new CatStream();
        catalan.print();
    }
}
