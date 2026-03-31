import java.util.*;
public class twoPointer{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements: ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

         System.out.println("Enter the target: ");
         int target = sc.nextInt();

         int left = 0;
         int right = n - 1;
         boolean found = false;

         while(left < right){
            int sum = arr[left] + arr[right];

            if(sum == target){
                 System.out.println("Pair found:- " + arr[left] + ", " + arr[right]);
                 found = true;
                 left++;
                 right--;
            }

            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
         }

         if(!found){
             System.out.println("No pair exist.");
         }
         sc.close();
    }
}