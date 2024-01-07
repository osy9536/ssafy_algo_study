package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static final int P = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long N = 1, S = 0;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            S = s * N + S * n;
            N *= n;
            S %= P;
            N %= P;
        }
        if(S % N != 0)
            bw.write((search(N, P-2) * S) % P + "");
        else
            bw.write(S/N + "");
        bw.flush();
        bw.close();
        br.close();
    }
    static long search(long N, int index) {
        if(index == 1)
            return N;
        long temp = search(N, index/2);
        if(index % 2 == 1)
            return temp * temp % P * N % P;
        else
            return temp * temp % P;
    }
}