package other;

public class Outer {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            if (i * i < 36) {
                continue;
            }
            System.out.print(i + " ");
        }
    }
}




//    class Inner {
//        Inner() {
//            System.out.println("Создание объекта внутреннего класса");
//        }
//    }
//    static class Nested {
//        Nested() {
//            System.out.println("Создание объекта вложенного класса");
//        }
//    }

