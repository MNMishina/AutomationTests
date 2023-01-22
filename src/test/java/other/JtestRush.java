package other;

public class JtestRush {
    static class Calculator {

        public static void add(int a, int b) {
            System.out.println(a + " + " + b + EQUAL + (a + b));
        }

        public static void subtract(int a, int b) {
            System.out.println(a + " - " + b + EQUAL + (a - b));
        }

        public static void multiply(int a, int b) {
            System.out.println(a + " * " + b + EQUAL + (a * b));
        }

        public static void divide(int a, int b) {
            System.out.println(a + " / " + b + EQUAL + (a / b));
        }

    }

    public static final String EQUAL = " = ";

    public static void main(String[] args) {
        int a = 45;
        int b = 15;
        JtestRush.Calculator.add(a, b);
        JtestRush.Calculator.subtract(a, b);
        JtestRush.Calculator.multiply(a, b);
        JtestRush.Calculator.divide(a, b);
    }
}
