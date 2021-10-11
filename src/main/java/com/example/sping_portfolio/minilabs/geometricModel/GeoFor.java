package com.example.sping_portfolio.minilabs.geometricModel;

public class GeoFor extends _Geometric {
    public GeoFor(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "For";
        long limit = super.size;
        int terms = 1;
        for (int i = 0; i < limit; i++)
        {
            super.setData(terms);
            terms *= 2;

        }
    }

    public static void main(String[] args) {
        int num = 92;   //number of Fibs, 92 is max for long
        _Geometric geometric = new GeoFor(num);
        geometric.print();
    }
}