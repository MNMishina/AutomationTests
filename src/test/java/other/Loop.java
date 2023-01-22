package other; /**
 * Write a program that takes two integers as the input: the beginning and the end of the interval (both numbers belong to the interval).
 * <p>
 * The program should output the numbers from this interval, but if the number is divisible by 3, you should output Fizz instead of it;
 * <p>
 * if the number is divisible by 5, output Buzz; and if it is divisible both by 3 and by 5, output FizzBuzz.
 * <p>
 * Output each number or the word on a separate line.
 */

import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        for (int i = a; i <= b; i++) {
            if (i % 3 == 0 && i % 5 == 0) {            // это условие одновременного деления на 3 и на 5 должно быть на 1м месте
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }
}





