package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15651 {


    // N은 내가 가용할 수 있는 수
    // M은 내가 나열할 숫자의 수
    static int N,M;
    static boolean [] isVisted;
    static int [] arr;

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        // 값 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisted = new boolean[N];
        arr = new int[M];
        cal(0);

        System.out.println(sb);
    }

    public static void cal(int deepth) {

        if(deepth == M){
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }


        for (int i = 0; i < N; i++) {
            arr[deepth] = i+1;
            cal(deepth+1);


        }
    }
}
