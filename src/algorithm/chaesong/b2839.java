package algorithm.chaesong;

import java.util.Scanner;

public class b2839 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        while(N > 0){
            if(N % 5 == 0) {
                cnt += N / 5;
                System.out.println(cnt);
                return;
            }
            if(N < 3){
                System.out.println(-1);
                //�Լ� ����
                return;
            }
            N -= 3;
            cnt++;
        }
        System.out.println(cnt);
    }
 }
