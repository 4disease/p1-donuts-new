
package com.example.sping_portfolio.algorithm.pellModel;

public class PellFor extends com.example.sping_portfolio.algorithm.pellModel._Pell {
    // zero and one argument constructors, both defer to super
    public PellFor() { super(); }
    public PellFor(int nth) {
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
        for (long[] f = new long[]{0, 1}; limit-- > 0 && n++ > 0; f = new long[]{f[1], 2 * f[1] + f[0]})
            super.setData(f[0]);
    }

    /*
    Class method "main" with purpose of testing FibFor
     */
    public static void main(String[] args) {
        com.example.sping_portfolio.algorithm.pellModel._Pell pell = new PellFor(); // "FibFor" is used as initializer for the "_Fibonacci fibonacci"  object
        pell.print();
    }
}