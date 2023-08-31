package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2023 {
    static int N;
    static int[] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N  = Integer.parseInt(br.readLine());
        res = new int[N];
        int[] prime = {2,3,5,7};
        for (int i = 0; i < 4; i++) {
            check(1,prime[i]);
        }
    }
    static int check(int cnt,int num){
        if(cnt == N){
            System.out.println(num);
        }
        for (int i = 1; i < 10 ; i++) {
            if(i%2 == 0) continue;
            if(isPrime(num*10 + i))
                check(cnt+1,num*10+i);
        }
        return 0;
    }
    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}

