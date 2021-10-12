package com.example.sping_portfolio.algorithm.catalanModel;

public class CatRecurse extends com.example.sping_portfolio.algorithm.catalanModel._Catalan {
    public CatRecurse() {
        super();
    }
    public CatRecurse(int nth) {
        super(nth);
    }

    /*
    Abstract Polymorphic "init()" method using Recursion
    */
    @Override
    protected void init() {
        //setup for recursion
        super.name = "Recursion";
        long limit = super.size;
        int n = 1;
        long[] f = new long[]{1, 1};
        initRecurse(limit, n, f);       // recursion is redirected
    }

    /*
    Recursive methods contains an escape, in this  "base condition" with a limit
    VERY IMPORTANT... recursion requires pre-decrement, post-decrement will not occur until unstacking
     */
    private void initRecurse(long limit, int n , long[] f) {
        if (limit == 0 && n > 0) return;                                 //exit condition
        super.setData(f[0]);
        // observe this syntax and function, many think of recursion as another way to do iteration
        initRecurse(--limit, ++n, new long[]{f[1], f[1] * 2 * n * (2 * n - 1) / (n * n + n)});
    }

    /*
    Class method "main" with purpose of testing CatRecurse
     */
    public static void main(String[] args) {
        com.example.sping_portfolio.algorithm.catalanModel._Catalan catalan = new CatRecurse();  // "CatRecurse" is used as initializer for the "_Catalan catalan"  object
        catalan.print();
    }
}
