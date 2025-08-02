package Array.TwoDArray;
import java.util.Scanner;

public class Creation {
    public static boolean SearchInMatrix(int[][] matrix, int key){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==key){
                    System.out.println("Key found at index: " + i + " " + j);
                    return true;
                }
            }
        }
        System.out.println("Key not found");
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrix = new int[4][3];
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Enter the elements of matrix: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Enter the key to search: ");
        int key = sc.nextInt();
        SearchInMatrix(matrix, key);
    }
}
