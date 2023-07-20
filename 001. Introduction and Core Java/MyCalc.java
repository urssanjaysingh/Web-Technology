interface Calc {
    void sum(int a, int b);

    void sub(int a, int b);
}

class MyCalc implements Calc {
    public void sum(int a, int b) {
        System.out.println("Sum is = " + (a + b));
    }

    public void sub(int a, int b) {
        System.out.println("Sub is = " + (a - b));
    }
    
    public static void main(String[] args) {
        MyCalc cal = new MyCalc();
        cal.sum(100, 20);
        cal.sub(100, 20);
    }
}
