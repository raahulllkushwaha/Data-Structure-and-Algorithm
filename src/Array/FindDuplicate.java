// This code will true if the duplicate will find and if not then it returns false.
package Array;
import java.util.Scanner;
public class FindDuplicate {

        public static boolean findDuplicate(int[] nums) {
            for(int i = 0; i< nums.length -1; i++){
                for(int j=i+1; j < nums.length;j++)
                    if (nums[i] == nums[j]) {
                        return true;
                    }
            }
            return false;
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
            System.out.println("Duplicates Find: " + findDuplicate(arr));

            sc.close();
        }
    }

