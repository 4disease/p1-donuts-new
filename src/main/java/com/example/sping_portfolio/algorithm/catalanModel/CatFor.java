
package com.example.sping_portfolio.algorithm.catalanModel;

import com.example.sping_portfolio.algorithm.pellModel.PellFor;
import com.example.sping_portfolio.algorithm.pellModel._Pell;

public class CatFor extends _Catalan {
    public CatFor(int nth) {
        super(nth);
    }

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
        int num = 92;
        _Catalan cat = new CatFor(num);
        cat.print();
    }
}