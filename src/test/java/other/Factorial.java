package other; /**
 * The smallest value
 * A user inputs a long positive number m. You need to find out what is the smallest int number n such that n! > m.
 *
 * n!, or factorial n, is a product of all natural numbers from 1 to n inclusive: for example, 5! = 1 * 2 * 3 * 4 * 5.
 *
 * For example, the user enters 100. This means m = 100 and n = 5 because 5! = 120 (see the factorial formula) and this is the smallest number that satisfies the condition n! > m.
 *
 * Pay attention that the user may input a really big number so choose an appropriate data type!
 */

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        scanner.close();
        long n = 1;
        //int count = 0;

        int i = 1;
        while (true) {
            n = n * i;
            //count++;
            i++;
            if (n > m) {
                System.out.println(i - 1);
                break;
            }
        }
    }
}

