package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11660_v1 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] prefix = new int [N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                prefix[i][j] = prefix[i][j-1] + Integer.parseInt(st.nextToken());
                // 해당 행의 이전 열의 누적합 + 입력된 수
            }
        }
        ///////////////////////////////////////////////////////////////////////////////

        StringBuilder  sb = new StringBuilder();
        for(int i = 1;i<=M;i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int j = x1;j<=x2;j++) {
                sum = sum + (prefix[j][y2] - prefix[j][y1-1]);
            }
            sb.append(sum+"\n");
            //System.out.println(sum);
        }
        System.out.println(sb);
    }
}


