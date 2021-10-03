package models;

public class ArithmeticFor extends _Arithmetic {
    // zero and one argument constructors, both defer to super
    public ArithmeticFor() { super(); }
    public ArithmeticFor(int nth) {
        super(nth);
    }

    /*
    Abstract Polymorphic "init()" method using For
     */
    @Override
    protected void init() {
        super.name = "For";
        long limit = super.size;
        // for loops are likely the most common iteration structure, all the looping facts are in one line
        for (long[] f = new long[]{0, 1}; limit-- > 0; f = new long[]{f[1], f[0] + 2})
            super.setData(f[0]);
    }

    /*
    Class method "main" with purpose of testing FibFor
     */
    public static void main(String[] args) {
        _Arithmetic arithmetic = new ArithmeticFor(); // "FibFor" is used as initializer for the "_Fibonacci fibonacci"  object
        arithmetic.print();
    }
}