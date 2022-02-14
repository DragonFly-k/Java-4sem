package by.belstu.it.syatkovskaya;

public class TextFunction {
    public String getValue() {
        for (int count = 0; count <10; count++) {
         System.out.println("Counter "+count);
        }
        return "Hello World";
    }

    public int test;
    public TextFunction() {}
    public int getTest() {
        return test;
    }
    public void setTest(int test) {
        this.test = test;
    }

    final int pr1 = 1;
    public final int pr2 = 2;
    public static final int pr3 = 3;
}
