package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b2447 {
    static char[][] ans;
    public static void main(String[] args) throws IOException{ //메인
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ans = new char[n][n];
        star(0,0,n,false);
        for(int i=0;i<n;i++) {
            bw.write(ans[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    public static void star(int x,int y,int m,boolean blank){ // star함수
        if(blank) {
            for(int i=x;i<x+m;i++) {
                for(int j=y;j<y+m;j++)
                    ans[x][y]=' ';
            }
            return ;
        }
        if(m==1) {
            ans[x][y]='*';
            return;
        }
        int size=m/3;
        int cnt=0;
        for(int i=x;i<x+m;i+=size) {
            for(int j=y;j<y+m;j+=size) {
                cnt++;
                if(cnt==5)
                    star(i,j,size,true);
                else
                    star(i,j,size,false);
            }
        }
    }
}
//import java.util.Scanner;
//        import java.io.BufferedWriter;
//        import java.io.OutputStreamWriter;
//        import java.io.IOException;
//
//public class Main {
//    static char[][] arr;
//
//    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        arr = new char[N][N];
//        star(0, 0, N, false);
//        for (int i = 0; i < N; i++) {
//            bw.write(arr[i]);
//            bw.write("\n");
//        }
//        bw.flush();
//        bw.close();
//    }
//    static void star(int x, int y, int N, boolean blank) {
//        if (blank) {
//            for (int i = x; i < x + N; i++) {
//                for (int j = y; j < y + N; j++) {
//                    arr[i][j] = ' ';
//                }
//            }
//            return;
//        }
//        if (N == 1) {
//            arr[x][y] = '*';
//            return;
//        }
//        int size = N / 3;
//        int count = 0;
//        for (int i = x; i < x + N; i += size) {
//            for (int j = y; j < y + N; j += size) {
//                count++;
//                if (count == 5) { // 공백 칸일 경우
//                    star(i, j, size, true);
//                } else {
//                    star(i, j, size, false);
//                }
//            }
//        }
//    }
//}
