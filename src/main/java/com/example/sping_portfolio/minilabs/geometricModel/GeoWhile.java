package com.example.sping_portfolio.minilabs.geometricModel;

public class GeoWhile extends _Geometric {
    public GeoWhile(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "While";
        long limit = super.size;

        int i = 0;
        int terms = 1;
        while (i < limit) {
            super.setData(terms);
            terms *= 2;
            i++;
        }
    }

    public static void main(String[] args) {
        int num = 92;   //number of Fibs, 92 is max for long
        _Geometric geometric = new GeoWhile(num);
        geometric.print();
    }
}