package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 소수의 연속합
// gold 3
public class b1644 {
    static int N, answer;
    static boolean[] prime;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N==1){
            System.out.println(0);
            return;
        }
        if(N==2||N==3){
            System.out.println(1);
            return;
        }
        answer=0;
        prime = new boolean[N+1];
        list = new ArrayList<>();
        Prime();
        for (int i = 0; i < prime.length; i++) {
            if(!prime[i]) list.add(i);
        }
        TwoPoint(0,1);
        System.out.println(answer);
    }

    private static void TwoPoint(int left, int right) {
        int sum = list.get(left)+list.get(right);
        while (true) {
            if(sum==N) {
                answer++;
                right++;
                if(right==list.size()) break;
                sum += list.get(right);
            }

            else if(sum>N){
                if(left==list.size()) break;
                sum -= list.get(left);
                left++;

            }

            else if (sum < N) {
                right++;
                if(right==list.size()) break;
                sum += list.get(right);
            }

        }
    }

    private static void Prime() {
        prime[0] = prime[1] = true;
        for (int i = 0; i *i<=N; i++) {
            if (!prime[i]) {
                for (int j = i*i; j <=N ; j+=i) {
                    prime[j]=true;
                }
            }
        }
    }
}
