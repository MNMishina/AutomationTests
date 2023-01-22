package other;

import java.util.Scanner;

public class Sold {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: \n > ");
        int a = scanner.nextInt();
        System.out.print("Enter the number of seats in each row: \n > ");
        int b = scanner.nextInt();
        scanner.close();
        Integer seat = a * b;
        Integer income;

        if (a > 10 & b > 10) {
            System.out.println("Wrong input. Please try again.");
            return;
        }
        if (seat < 61) {
            System.out.println("Total income: \n $" + (seat * 10));
        } else if (seat > 61) {

            if (a % 2 == 0) {
                income = (a / 2 * b) * 10 + (a / 2 * b) * 8;
                System.out.println("Total income: \n $" + income);
            } else if (a % 2 != 0) {
                income = (a / 2 * b) * 10 + ((a - a / 2) * b) * 8;
                System.out.println("Total income: \n $" + income);
            }
        }
    }
}
