package Array;
import java.util.Scanner;
public class LargestInArray {
    public static int findLargest(int[] nums){
       int max = nums[0];
       for(int i = 0; i<nums.length;i++){
           if(nums[i] > max){
               max = nums[i];
           }
       }
       return max;
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
        System.out.println("Largest element is: " + findLargest(arr));

    sc.close();
    }
}
