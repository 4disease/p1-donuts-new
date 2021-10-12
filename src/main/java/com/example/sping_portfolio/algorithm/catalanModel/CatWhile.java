package com.example.sping_portfolio.algorithm.catalanModel;

public class CatWhile extends com.example.sping_portfolio.algorithm.catalanModel._Catalan {
    public CatWhile() {
        super();
    }
    public CatWhile(int nth) {
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
        long[] f = new long[]{1, 1};
        while (limit-- > 0 && n++ > 0) {
            super.setData(f[0]);
            f = new long[]{f[1], f[1] * 2 * n * (2 * n - 1) / (n * n + n)};
        }
    }

    /*
    Class method "main" with purpose of testing CatWhile
     */
    public static void main(String[] args) {
        com.example.sping_portfolio.algorithm.catalanModel._Catalan catalan = new CatWhile();
        catalan.print();
    }
}
