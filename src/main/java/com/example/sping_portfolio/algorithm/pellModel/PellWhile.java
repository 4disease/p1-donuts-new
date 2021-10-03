package com.example.sping_portfolio.algorithm.pellModel;

public class PellWhile extends com.example.sping_portfolio.algorithm.pellModel._Pell {
    public PellWhile() {
        super();
    }
    public PellWhile(int nth) {
        super(nth);
    }

    /*
    Abstract Polymorphic "init()" method using While
    */
    @Override
    protected void init() {
        super.name = "While";
        int n = 1;
        // longer and more error prone "while" syntax is often best performer in this small scale test
        long limit = super.size;
        long[] f = new long[]{0, 1};
        while (limit-- > 0 && n++ > 0) {
            super.setData(f[0]);
            f = new long[]{f[1], 2 * f[1] + f[0]};
        }
    }

    /*
    Class method "main" with purpose of testing FibWhile
     */
    public static void main(String[] args) {
        com.example.sping_portfolio.algorithm.pellModel._Pell pell = new PellWhile();
        pell.print();
    }
}
