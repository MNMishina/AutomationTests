package other;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt(); // reading a length
        int[] array = new int[len];  // creating an array with the specified length

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt(); // read the next number of the array
        }
        int n = scanner.nextInt();
        scanner.close();
        int quantity = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                quantity++;
            }
        }
        System.out.println(quantity);
       // System.out.println(Arrays.toString(array));

    }
}



