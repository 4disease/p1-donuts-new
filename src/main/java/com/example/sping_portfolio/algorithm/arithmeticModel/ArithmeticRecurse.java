package com.example.sping_portfolio.algorithm.arithmeticModel;

public class ArithmeticRecurse extends _Arithmetic {

    public ArithmeticRecurse(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        //setup for recursion
        super.name = "Recursion";
        long limit = super.size;
        long[] f = new long[]{1, 2};
        initRecurse(limit,f);
    }

    private void initRecurse(long limit, long[] f) {
        if (limit == 0) return;                                 //exit condition
        super.setData(f[0]);
        initRecurse(--limit, new long[]{f[1], f[1] +1 });    //recursion requires pre-increment


    }

    public static void main(String[] args) {
        int num = 10;   //number of Fibs, 92 is max for long
        _Arithmetic geometric = new ArithmeticRecurse(num);
        geometric.print();
    }
}