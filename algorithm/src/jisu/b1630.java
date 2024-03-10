package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1630 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] sosu = new int[n+1];
        for (int i = 2; i <= n; i++) {
            sosu[i] = i;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 2; i <= n; i++) {
            if (sosu[i] == i) set.add(i);
            else if (!set.contains(sosu[i])) continue;
            for (int j = i*2; j <= n; j += i) {
                sosu[j] /= sosu[i];
            }
        }

        long result = 1;
        for (int i = 2; i < n+1; i++) {
            result = result * sosu[i] % 987654321;
        }

        System.out.println(result);

    }
}