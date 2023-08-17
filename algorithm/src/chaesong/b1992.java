import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1992 {
    static int N;
    static int arr[][];
    static StringBuilder sb;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        quard(0, 0, N);
        System.out.println(sb);
    }
    static void quard(int i, int j, int size) {
        //만약 같은 숫자로 이루어진 칸이라면
        if(isZip(i, j, size)) {
            sb.append(arr[i][j]); return; 
        }
        
        //아니라면 쪼개기
        int newSize = size/2;
        sb.append("(");
        quard(i, j, newSize);
        quard(i, j+newSize, newSize);
        quard(i+newSize, j, newSize);
        quard(i+newSize, j+newSize, newSize);
        sb.append(")");
    }
    static boolean isZip(int i, int j, int size) {
        int start = arr[i][j];
        for(int x = i; x < i+size; x++) {
            for(int y = j; y < j+size; y++) {
                //중간에 다른 게 나오면 false 리턴
                if(arr[x][y] != start) return false;
            }
        }
        //걸리는 것 없이 포문 탈출-> true 리턴
        return true;
    }
}
