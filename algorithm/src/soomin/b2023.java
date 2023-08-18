package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2023 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 첫 번째 수는 처리 한 채로 주자
        primeSearch(2,1);
        primeSearch(3,1);
        primeSearch(5,1);
        primeSearch(7,1);


    }

    // 백트래킹 -> 소수판정으로 지금까지 모은 수가 소수면 GO, 아니면 Back
    public static void primeSearch(int num, int deepth) {

        if(deepth == N) {
            System.out.println(num);
            return;
        }


        int nextNum;

        for(int i = 0; i< 10; i++) {
            nextNum = num*10 + i;
            if(judgeMent(nextNum)) {
                primeSearch(nextNum, deepth+1);
            }
        }
        return;

    }

    // 소수 판정 -> 값이 소수인지 판정
    public static boolean judgeMent(int num) {
        int i = 2;
        while(i <= Math.sqrt(num)) {
//    		System.out.println(num/i);
            if(num%i == 0) {
                return false;
            }
            i++;
        }

        return true;
    }
}
