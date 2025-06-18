import java.util.Scanner;
public class BinaryToDecimal {
    public static void BinToDec(int binNum){
        int myNum = binNum;
        int pow = 0;
        int decimalNum = 0;

        while (binNum > 0){
            int lastDigit = binNum % 10;
            decimalNum = decimalNum + (lastDigit * (int)Math.pow(2, pow));
            pow++;
            binNum = binNum / 10;
        }
        System.out.println("Decimal of " + myNum + " is: " + decimalNum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Binary number to convert it into Decimal number: ");
        int n = sc.nextInt();
        BinToDec(n);

        sc.close();;
    }

}
