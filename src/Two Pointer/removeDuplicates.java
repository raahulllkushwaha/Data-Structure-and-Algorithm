import java.util.*;
public class removeDuplicates{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
          
       
        System.out.println("Enter the size of the array: ");
        int num = sc.nextInt();
        int[] arr = new int[num];
        // int n = arr.length;

        System.out.println("Enter the elements: ");
         for(int i = 0; i < num; i++){
             arr[i] = sc.nextInt();
        }
        int officer = 0;
        int cm = 1;
        int res=1;
        while(cm < num){  
            if(arr[cm] == arr[cm - 1]){
                cm++;
                continue;
            }
            arr[officer + 1] = arr[cm];
            officer++;
            res++;
            cm++;
        }
        System.out.println("Array after removing duplicates: ");
        for(int i = 0; i< res;i++){
             System.out.print(arr[i] + " ");
        }

        System.out.println("\nTotal unique elements: " + res);

        sc.close();
        }

    }
