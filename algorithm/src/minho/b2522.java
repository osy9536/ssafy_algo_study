package algorithm.src.minho;

//2522번 별찍기
import java.util.Scanner;

public class b2522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            for (int j=n-i; j>=1; j--) {
                System.out.print(" ");
            }
            for (int j=1; j<=i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        for (int i=1; i<=n-1; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print(" ");
            }
            for (int j=n-i; j>=1; j--) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}