package algorithm.src.ohseyoung;

import java.io.*;

// k번째 수
public class b1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int ans = 0;
//        1 2 3 4;
//        2 4 6 8;
//        3 6 9 12;
//        4 8 12 16;
        int start = 1, end = k, middle;

        while (start <= end) {
            middle = (start + end) / 2;
            long cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(middle / i, n);
            }
            if (cnt < k) {
                start = middle + 1;
            } else {
                ans = middle;
                end = middle - 1;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
