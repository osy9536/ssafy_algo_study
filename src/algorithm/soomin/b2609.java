package algorithm.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class b2609  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(G(A,B));
        System.out.println((A*B)/G(A,B));
    }

    public static int G (int a, int b){
        int max = Math.max(a,b);
        int min = Math.min(a,b);

        while(max%min > 0){
            int r = min;
                min = max%r;
                max = r;

        }
        return min;
    }
}

