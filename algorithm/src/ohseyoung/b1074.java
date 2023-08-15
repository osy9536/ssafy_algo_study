package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Z
// silver 1
public class b1074 {
    static int cnt;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int pow = (int) Math.pow(2, n);
        cnt = 0;
        divideConquer(pow, r, c);
//        System.out.println(Arrays.deepToString(map));
        System.out.println(cnt);
    }


    static void divideConquer(int size, int r, int c) {
        if(size == 1)
            return;

        if(r < size/2 && c < size/2) {
            divideConquer(size/2, r, c);
        }
        else if(r < size/2 && c >= size/2) {
            cnt += size * size / 4;
            divideConquer(size/2, r, c - size/2);
        }
        else if(r >= size/2 && c < size/2) {
            cnt += (size * size / 4) * 2;
            divideConquer(size/2, r - size/2, c);
        }
        else {
            cnt += (size * size / 4) * 3;
            divideConquer(size/2, r - size/2, c - size/2);
        }
    }
}
