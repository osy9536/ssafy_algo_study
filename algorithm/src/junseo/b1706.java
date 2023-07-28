package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
b1706_크로스워드
2차원배열 탐색
배열의 끝 주의
 */
public class b1706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int i, j;
        char[][] arr = new char[R][C];
        for (i = 0; i < R; i++) {
            String str = br.readLine();
            for (j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        /////////////////////////////////////////////////////////////

        String str = "";
        String ans = "";
        for (i = 0; i < R; i++) {
            str = "";
            for (j = 0; j <= C; j++) {
                if (j==C||arr[i][j] == '#') {
                    if(str.length()>=2){
                        if (ans.length() == 0) ans = str;
                        else if (ans.compareTo(str) > 0) ans = str;
                    }
                    str = "";
                }else str += arr[i][j];
            }
        }

        //////////////////////////////////////////////////////////////
        for (i = 0; i < C; i++) {
            str = "";
            for (j = 0; j <= R; j++) {
                if (j==R||arr[j][i] == '#') {
                    if(str.length()>=2){
                        if (ans.length() == 0) ans = str;
                        else if (ans.compareTo(str) > 0) ans = str;
                    }
                    str = "";
                }else str += arr[j][i];
            }
        }
        System.out.println(ans);
    }
}


