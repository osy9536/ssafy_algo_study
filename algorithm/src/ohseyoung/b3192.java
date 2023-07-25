package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int[][] arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 0) {
                    sum = 0;
                    break;
                }
                sum += arr[i][j];
            }
            if (sum != 0) break;
            for (int j = 0; j < 3; j++) {
                if (arr[j][i] == 0) {
                    sum = 0;
                    break;
                }
                sum += arr[j][i];
            }
            if (sum != 0) break;
        }
        // 대각선
        if (sum == 0) {
            if (arr[0][0] != 0 && arr[1][1] != 0 && arr[2][2] != 0) sum += arr[0][0] + arr[1][1] + arr[2][2];
            if (arr[0][2] != 0 && arr[1][1] != 0 && arr[2][0] != 0) sum += arr[0][2] + arr[1][1] + arr[2][0];
        }


        if (sum == 0) {
            sum = 3 * (arr[0][1] + arr[2][1]) / 2;
        } // sum 값 구하기 완료

        // 1,1이 0일때
        if ((arr[0][0]==0&&arr[1][1] == 0&&arr[2][2]==0)||(arr[0][2]==0&&arr[1][1]==0&&arr[2][0]==0)) arr[1][1] = sum - (arr[0][1] + arr[2][1]);
        boolean isTrue = true;
        while (isTrue) {
            for (int i = 0; i < 3; i++) {
                int cnt = 0;
                int temp = 0;
                int a = 0, b = 0;
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] == 0) {
                        a = i;
                        b = j;
                        cnt++;
                    }
                }
                if (cnt == 1) {
                    for (int j = 0; j < 3; j++) {
                        if (i != a || j != b) temp += arr[i][j];
                    }
                    arr[a][b] = sum - temp;
                } else {
                    cnt = 0;
                    for (int j = 0; j < 3; j++) {
                        if (arr[j][i] == 0) {
                            a = j;
                            b = i;
                            cnt++;
                        }
                    }
                    if (cnt == 1) {
                        for (int j = 0; j < 3; j++) {
                            if (j != a || i != b) temp += arr[j][i];
                        }
                        arr[a][b] = sum - temp;
                    }
                }

            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] == 0) {
                        isTrue = true;
                        break;
                    } else isTrue = false;
                }
                if (isTrue) break;
            }
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
