package com.example.sping_portfolio.algorithm.arithmeticModel;

public class ArithmeticFor extends _Arithmetic {
    public ArithmeticFor(int nth) {
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
            terms ++;

        }
    }

    public static void main(String[] args) {
        int num = 10;   //number of Fibs, 92 is max for long
        _Arithmetic arithmetic = new ArithmeticFor(num);
        arithmetic.print();
    }
}