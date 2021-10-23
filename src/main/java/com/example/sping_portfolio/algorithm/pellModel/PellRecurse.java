package com.example.sping_portfolio.algorithm.pellModel;

public class PellRecurse extends _Pell {

    public PellRecurse(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        //setup for recursion
        super.name = "Recursion";
        long limit = super.size;
        int n = 1;
        long[] f = new long[]{0, 1};
        initRecurse(limit, n, f);
    }

    private void initRecurse(long limit, int n , long[] f) {
        if (limit == 0 && n > 0) return;
        super.setData(f[0]);
        initRecurse(--limit, ++n, new long[]{f[1], 2 * f[1] + f[0]});
    }

    /*
    Class method "main" with purpose of testing FibRecurse
     */
    public static void main(String[] args) {
        com.example.sping_portfolio.algorithm.pellModel._Pell pell = new PellRecurse(3);  // "FibRecurse" is used as initializer for the "_Fibonacci fibonacci"  object
        pell.print();
    }
}
