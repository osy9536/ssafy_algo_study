package algorithm.src.chaesong;

import java.math.BigInteger;
import java.util.Scanner;

public class b11729 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        while(N >= 5){
            ans += N/5;
            N /= 5;
        }
        System.out.println(ans);
    }
}
