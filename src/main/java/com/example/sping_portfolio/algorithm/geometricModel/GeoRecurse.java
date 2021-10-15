package com.example.sping_portfolio.algorithm.geometricModel;

public class GeoRecurse extends _Geometric {

    public GeoRecurse(int nth) {
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
        initRecurse(--limit, new long[]{f[1], f[1] * 2});    //recursion requires pre-increment


    }

    public static void main(String[] args) {
        int num = 92;   //number of Fibs, 92 is max for long
        _Geometric geometric = new GeoRecurse(num);
        geometric.print();
    }
}