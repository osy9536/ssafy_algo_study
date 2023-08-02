package algorithm.soomin;

import java.util.ArrayList;
import java.util.Scanner;


public class b1193 {
    public static void main(String[] args) {

        // 입력 받기
        Scanner sc =new Scanner(System.in);
        ArrayList<two> list = new ArrayList<>();
        int N = sc.nextInt();

        // 입력 받은 값에서 계산해야할 분수들 추리기.
        int i = 0;
        while(N > 0){
            if(N <=i) break;
            N -=i;
            i++;
        }

        if(i%2 ==0){

            for (int j = 0; j < i; j++) {
                list.add(new two(j+1, i-j));
            }

        } else if (i%2 == 1) {
            for (int j = 0; j < i; j++) {
                list.add(new two(i-j, j+1));
            }

        }



        System.out.println(list.get(N-1).numerator +"/"+list.get(N-1).denominator);




    }

    static class two {
        int numerator;
        int denominator;

        public two(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

    }
}

