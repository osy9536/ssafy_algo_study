package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int l = Integer.parseInt(br.readLine());
        int[] arr = new int[l];
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < l; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        int n = Integer.parseInt(br.readLine());


        int answer = 0;
        if (!set.contains(n)) {
            Arrays.sort(arr);
            int small = 1;
            int big = n;
            for (int i = 0; i < l; i++) {
                if (n < arr[i]) {
                    big = arr[i]-1;
                    if (i != 0) {
                        small = arr[i-1]+1;
                    }
                    break;
                }
            }

            for (int i = small; i <= n; i++) {
                for (int j = n; j <= big; j++) {
                    answer++;
                }
            }

            answer--;
        }

        System.out.println(answer);


        
    }
}