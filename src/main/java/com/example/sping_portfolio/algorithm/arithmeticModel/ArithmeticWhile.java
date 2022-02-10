package com.example.sping_portfolio.algorithm.arithmeticModel;


public class ArithmeticWhile extends _Arithmetic {
    public ArithmeticWhile(int nth) {
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
            terms ++;
            i++;
        }
    }

    public static void main(String[] args) {
        int num = 10;   //number of Fibs, 92 is max for long
        _Arithmetic geometric = new ArithmeticWhile(num);
        geometric.print();
    }
}