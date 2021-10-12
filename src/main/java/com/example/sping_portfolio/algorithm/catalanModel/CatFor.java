
package com.example.sping_portfolio.algorithm.catalanModel;

public class CatFor extends com.example.sping_portfolio.algorithm.catalanModel._Catalan {
    // zero and one argument constructors, both defer to super
    public CatFor() { super(); }
    public CatFor(int nth) {
        super(nth);
    }

    /*
    Abstract Polymorphic "init()" method using For
     */
    @Override
    protected void init() {
        super.name = "For";
        int n = 1;
        long limit = super.size;
        // for loops are likely the most common iteration structure, all the looping facts are in one line
        for (long[] f = new long[]{1, 1}; limit-- > 0 && n++ > 0; f = new long[]{f[1], f[1] * 2 * n * (2 * n - 1) / (n * n + n)})
            super.setData(f[0]);
    }

    /*
    Class method "main" with purpose of testing CatFor
     */
    public static void main(String[] args) {
        com.example.sping_portfolio.algorithm.catalanModel._Catalan catalan = new CatFor(); // "CatFor" is used as initializer for the "_Catalan catalan"  object
        catalan.print();
    }
}