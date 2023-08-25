package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2302 {
    static int [] ans = new int[50];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        cal();
        int [] arr  = new int[n+1];

        for(int i = 0;i<m;i++) {
            arr[Integer.parseInt(br.readLine())] = -1;
        }
    //////////////////////////////////////////////////////
        int cnt =0;
        int res = 1;
        for(int i = 1;i<=n+1;i++) {
            if((i == n+1 || arr[i] == -1)) {
                if(res==0) res=1;
                res *= ans[cnt];
                cnt = 0;
            }
            else cnt++;
        }
        System.out.println(res);
    }
    ////////////////////////////////////////////////
    public static void cal() {
        ans[0]=1;
        ans[1] = 1;
        ans[2] = 2;
        for(int i = 3;i<=40;i++) {
            ans[i] = ans[i-1]+ans[i-2];
        }
    }
}

