package algorithm.src.minho;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11444{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long[][] ans = recur(N);
        System.out.println(ans[0][1]);

    }
    public static long[][] base = new long[][]{{1, 1}, {1, 0}};
    public static long[][] recur(long N){
        long[][] temp = null;
        if(N == 1) return base;
        if(N % 2 == 0){
            temp = recur(N/2);
            return fun(temp, temp);
        } else {
            temp = recur((N-1)/2);
            return fun(base, fun(temp, temp));
        }
    }

    public static long div = 1000000007;
    public static long[][] fun(long[][] a, long[][] b){
        long[][] answer = new long[2][2];

        answer[0][0] = (a[0][0]*b[0][0] + a[0][1]*b[1][0])% div;
        answer[0][1] = (a[0][0]*b[0][1] + a[0][1]*b[1][1])% div;
        answer[1][0] = (a[1][0]*b[0][0] + a[1][1]*b[1][0])% div;
        answer[1][1] = (a[1][0]*b[0][1] + a[1][1]*b[1][1])% div;

        return answer;
    }

}