package Array;

import java.util.Scanner;

public class PairsInAnArray {
    public static void findPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + currentElement + ", " + arr[j] + ")" + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements of an Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Original Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Pairs: ");
        findPairs(arr);
        sc.close();
    }
}

