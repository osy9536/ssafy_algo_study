package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1062 {
    static int N,K;
    static boolean[] check;
    static String[] arr;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new boolean[27];
        arr =  new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        if(K >= 5) {
            check[0] = true; //a
            check[2] = true; //c
            check[8] = true; //i
            check[13] = true;//n
            check[19] = true;//t
            K -=5;
            comb(0,0);
        }

        System.out.println(res);
    }

    private static void comb(int x,int cnt) {
        if(cnt == K){
            calMax();
        }
        else {
            for (int i = x; i < 26; i++) {
                if (!check[i]) {
                    check[i] = true;
                    comb(i + 1, cnt + 1);
                    check[i] = false;
                }
            }
        }
    }

    private static void calMax() {
        boolean flag;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            flag = false;
            for (int j = 0; j <arr[i].length(); j++) {
                int a =  arr[i].charAt(j) - 'a';
                if(!check[a]) {
                    flag = true;
                    break;
                }
            }
            if(!flag) sum+=1;
        }
        res = Math.max(res,sum);
    }
}


