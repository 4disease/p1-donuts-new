package com.example.sping_portfolio.algorithm.pellModel;

public class PellFor extends _Pell {
    public PellFor(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "For";
        int n = 1;
        long limit = super.size;
        for (long[] f = new long[]{0, 1}; limit-- > 0 && n++ > 0; f = new long[]{f[1], 2 * f[1] + f[0]})
            super.setData(f[0]);
    }

    public static void main(String[] args) {
        int num = 92;
        _Pell pell = new PellFor(num);
        pell.print();
    }
}