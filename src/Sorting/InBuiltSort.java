import java.util.Scanner;
import java.util.Arrays;
public class InBuiltSort {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter " + size + " element of an array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array without sorting: ");
        printArray(arr);
        Arrays.sort(arr);
        System.out.println("Array after sorting: ");
        printArray(arr);
        sc.close();
    }
}
