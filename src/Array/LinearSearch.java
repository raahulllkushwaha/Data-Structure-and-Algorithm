package Array;
import java.util.Scanner;
public class LinearSearch {
    public static int linearSearch(int[] numbers, int key){
        for(int i = 0; i < numbers.length;i++){
            if(numbers[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements of an Array: ");
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i =0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Enter the key element you want to find: ");
        int key = sc.nextInt();
        System.out.println();
        System.out.println("Element found at index: " + linearSearch(arr, key));
    }
}
