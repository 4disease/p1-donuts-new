package com.example.sping_portfolio.algorithm.arithmeticModel;

import java.util.stream.Stream;

public class ArithmeticStream extends _Arithmetic {
    public ArithmeticStream(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "Stream";
        Stream.iterate(new long[]{1, 2}, f -> new long[]{f[1], f[1] +1})
                .limit(super.size)
                .forEach(f -> super.setData(f[0]) );
    }

    public static void main(String[] args) {
        int num = 10;
        _Arithmetic geometric = new ArithmeticStream(num);
        geometric.print();
    }
}