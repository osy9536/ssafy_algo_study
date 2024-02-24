package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1644 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] sosu = new int[n+1];
        for (int i = 2; i < n + 1; i++) {
            sosu[i] = i;
        }

        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (sosu[i] == 0) continue;
            for (int j = i*i; j < n + 1; j+=i) {
                sosu[j] = 0;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            if (sosu[i] != 0) list.add(i);
        }

        int left = 0;
        int right = 0;
        int summ = 2;
        int answer = 0;
        while (left <= right && right < list.size()) {
            if (summ < n) {
                right++;
                if (right < list.size()) summ += list.get(right);
                else break;
            } else if (summ > n) {
                left++;
                if (left <= right && right < list.size()) summ -= list.get(left-1);
                else break;
            } else {
                answer++;
                left++;
                summ -= list.get(left-1);
            }
        }

        System.out.println(answer);
    }
}