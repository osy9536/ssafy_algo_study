package algorithm.src.jisu;

import java.io.*;

public class b23048 {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sosu = new int[n+1];
        int[] result = new int[n+1];
        for (int i = 2; i <= n; i++) {
            sosu[i] = i;
        }
        result[1] = 1;


        int color = 2;
        for (int i = 0; i <= Math.sqrt(n); i++) {
            if (sosu[i] == 0) continue;
            result[i] = color;
            for (int j = i * i; j <= n; j += i) {
                sosu[j] = 0;
                result[j] = color;
            }
            color++;
        }

        for (int i = (int) Math.sqrt(n) + 1; i <= n; i++) {
            if (sosu[i] != 0 && result[i] == 0) {
                result[i] = color;
                color++;
            }
        }

        System.out.println(color-1);
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) sb.append(result[i] + " ");
        System.out.println(sb.toString());
    }
}