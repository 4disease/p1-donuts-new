package com.example.sping_portfolio.algorithm.geometricModel;

import java.util.stream.Stream;

public class GeoStream extends _Geometric {
    public GeoStream(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "Stream";
        Stream.iterate(new long[]{1, 2}, f -> new long[]{f[1], f[1] * 2})
                .limit(super.size)
                .forEach(f -> super.setData(f[0]) );
    }

    public static void main(String[] args) {
        int num = 92;   //number of Fibs, 92 is max for long
        _Geometric geometric = new GeoStream(num);
        geometric.print();
    }
}