package Array;
import java.util.Scanner;
public class BinarySearch {

    public static int binarySearch(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) /2;

            //Comparison
            if(arr[mid] ==key){
                return mid;
            } else if (arr[mid] < key) {
                start = mid +1;
            }
            else{
                end = mid - 1;
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
        System.out.println("Enter the key element to search: ");
        int key = sc.nextInt();
        System.out.println("Element found in index: " + binarySearch(arr, key));

        sc.close();
    }
}
