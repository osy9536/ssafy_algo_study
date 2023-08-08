import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2630 {
    static int white;
    static int blue;
    static int A[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());A=new int[N][N];for(
                int i = 0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(isOne(0, 0, N)) {
            if(A[0][0] == 0) white++;
            else blue++;
        }
        else{
            colorNum(0, 0, A.length);
        }
        System.out.println(white);
        System.out.println(blue);
    }

    

    // 종이 쪼개기-> 색깔 개수 구하기
    static void colorNum(int x, int y, int N) {
        //종료조건
        if(N < 1) return;

        //색깔이 같다면?
        if(isOne(x, y, N)) {
            if(A[x][y] == 0) white++;
            else blue++;
            return;
        }

        //재귀호출
        int size = N/2;
        for(int i = x; i < x+N; i += size) {
            for(int j = y; j < y+N; j += size) {
                    colorNum(i, j, size);
            }
        }
    }

    
    // 잘린 종이는 같은 색일까?
    static boolean isOne(int x, int y, int N) {

        if(N == 1)
            return true;

        for(int i = x; i < x+N; i++) {
            for(int j = y; j < y+N; j++) {
                if(A[x][y] != A[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}