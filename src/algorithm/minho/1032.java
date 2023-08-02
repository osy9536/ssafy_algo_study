package algorithm.minho;

import java.util.Arrays;
import java.util.Scanner;

public class b1032 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] check = new int[50];
        Arrays.fill(check,0);
        int a = in.nextInt();
        String s = in.next();
        int l=s.length();
        for(int i =1;i<a;i++){
            String str = in.next();
            for(int j =0;j<l;j++){
                if(str.charAt(j)!=s.charAt(j))
                    check[j]++;
            }
        }
        for(int i =0;i<l;i++){
            if(check[i]==0)
                System.out.print(s.charAt(i));
            else
                System.out.print('?');
        }
    }
}
