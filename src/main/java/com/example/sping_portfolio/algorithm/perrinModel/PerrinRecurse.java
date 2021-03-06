package com.example.sping_portfolio.algorithm.perrinModel;

public class PerrinRecurse extends _Perrin {
    public PerrinRecurse() {
        super();
    }
    public PerrinRecurse(int nth) {
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
        long[] f = new long[]{0, 1};
        initRecurse(limit,f);       // recursion is redirected
    }

    /*
    Recursive methods contains an escape, in this  "base condition" with a limit
    VERY IMPORTANT... recursion requires pre-decrement, post-decrement will not occur until unstacking
     */
    private void initRecurse(long limit, long[] f) {
        if (limit == 0) return;                                 //exit condition
        super.setData(f[0]);
        // observe this syntax and function, many think of recursion as another way to do iteration
        initRecurse(--limit, new long[]{f[1], f[0] + f[1]});
    }

    /*
    Class method "main" with purpose of testing FibRecurse
     */
    public static void main(String[] args) {
        _Perrin perrin = new PerrinRecurse();  // "FibRecurse" is used as initializer for the "_Fibonacci "  object
        perrin.print();
    }
}
