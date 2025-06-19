package Array;

import java.util.Scanner;

public class SubArray {
    public static void printSubArray(int[] arr) {
        int totalSubArray = 0;
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int iterationSum = 0;
            int start = i;

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                iterationSum += sum;
                totalSum += sum;
                int end = j;

                int maxVal = arr[i];
                int minVal = arr[i];
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                    if(arr[k] > maxVal) {
                        maxVal = arr[k];
                    }
                    else{
                        minVal = arr[k];
                    }
                }
                totalSubArray++;
                System.out.println(" ---> Sum = " + sum + ", Max = " + maxVal + ", Min = " + minVal);
                System.out.println();
            }
            System.out.println("Sum of this iteration's subarray sums: " + iterationSum);
            System.out.println();
        }
        System.out.println("Total Sub Arrays are: " + totalSubArray);
        System.out.println("And the total sum is: " + totalSum);
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
        System.out.println("Sub Arrays: ");
        printSubArray(arr);
        sc.close();
    }
}



