import java.util.Scanner;
public class DecimalToBinary {
     public static void decToBin(int num){
         int pow = 0;
         int binNum = 0;

         while (num > 0){
             int rem = num % 2;
             binNum = binNum + (rem * (int)Math.pow(10, pow));
             pow++;
             num = num /2;
         }
         System.out.println("Binary of " + num + " is: " + binNum);
     }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Decimal number to convert it into Binary: ");
        int n = sc.nextInt();
        decToBin(n);

        sc.close();
    }
}
