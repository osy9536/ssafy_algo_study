package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] height = new int[3];
        int [] weight = new int[3];

        int i = 0;
        while(st.hasMoreTokens()){
            height[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        int h_min = Math.min(Math.abs(height[0] - height[1]), Math.abs(height[0] - height[2]));
        int w_min = Math.min(Math.abs(weight[0] - weight[1]), Math.abs(weight[0] - weight[2]));

        System.out.println(Math.min(h_min,w_min));

    }
}
