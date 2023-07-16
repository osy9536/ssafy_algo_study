package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        //블록 모양 구현
        int[][] world = new int[h][w];
        for(int i = 0; i < w; i++) {
            int tempH = Integer.parseInt(st.nextToken());

            for(int j = h - 1; j > h - tempH - 1; j--) {
                world[j][i] = 1;
            }
        }

        int sum = 0;
        for(int i = h - 1; i >= 0; i--) {
            for(int j = 1; j < w - 1; j++) {
                int cnt = 0;
                if(world[i][j] == 0) {
                    //왼쪽
                    for(int k = j - 1; k >= 0; k--) {
                        if(world[i][k] == 1) {
                            cnt++;
                            break;
                        }
                    }

                    //오른쪽
                    for(int k = j + 1; k < w; k++) {
                        if(world[i][k] == 1) {
                            cnt++;
                            break;
                        }
                    }

                    if(cnt == 2) {
                        sum += 1;
//						System.out.println(i + ", "+ j);
                    }

                }
            }
        }

        System.out.println(sum);

    }
}
