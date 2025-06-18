import java.util.Scanner;
public class BinomialCoefficient {

        public static long factorial(int n){
            if(n < 0){
                return -1;
            }
            if(n==0 || n==1){
                return 1;
            }
            return n * factorial(n - 1);
        }

        public static double binCoeff(int n, int r){
            double nFact = factorial(n);
           double rFact = factorial(r);
           double nmrFact = factorial(n - r);

            return nFact / (rFact * nmrFact);
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any to numbers to find nCr: ");
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println("The nCr of " + n + " and " + r +  " is: " + binCoeff(n, r));
    }
}