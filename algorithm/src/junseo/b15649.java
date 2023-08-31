package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15649 {
    static boolean [] flag;
    static int [] arr;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M+1];
        flag = new boolean[N+1];

        sol(0);

    }
    static void sol(int a) {
        if(a == M) {
            for(int i =0; i<M;i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println("");
        }else {
            for(int i = 1; i<=N;i++) {
                if(flag[i] == false) {
                    flag[i] = true;
                    arr[a] = i;
                    sol(a+1);
                    flag[i] = false;
                    arr[a] = 0;
                }
            }
        }
    }
}

