import java.util.Scanner;

public class CountingSort {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void countingSort(int[] arr){
        int largest = Integer.MIN_VALUE;
        for(int i =0; i<arr.length;i++){
            largest = Math.max(largest, arr[i]);
        }

        int[] count = new int[largest+1];
        for(int i =0; i<arr.length;i++){
            count[arr[i]]++;
        }
        //Sorting
        int j = 0;
        for(int i =0;i<arr.length;i++){
            while (count[i] > 0) {
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
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
        countingSort(arr);
        System.out.println("Array after sorting: ");
        printArray(arr);
        sc.close();
    }
}
