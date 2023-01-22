package other;

import java.util.Scanner;

/**
 * Write a program that will help people who are going on vacation. The program should calculate the total required sum (e.g. $) of money to have a good rest for a given duration.
 * <p>
 * There are four parameters which have to be considered:
 * <p>
 * duration in days
 * total food cost per day
 * one-way flight cost
 * cost of one night in a hotel (the number of nights equal duration minus one)
 * Read values of these parameters from the standard input and then print the result.
 */

public class VacationCost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input duration in days");
        int dur = scanner.nextInt();
        System.out.println("Input total food cost per day");
        int food = scanner.nextInt();
        System.out.println("Input one-way flight cost");
        int flight = scanner.nextInt();
        System.out.println("Input cost of one night in a hotel");
        int hotel = scanner.nextInt();
        scanner.close();

        System.out.println(food*dur+flight*2+hotel*(dur-1));
    }
}

