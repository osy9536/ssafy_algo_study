package algorithm.src.junseo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] A = str.toCharArray();
        str = br.readLine();
        char[] B = str.toCharArray();

        int ALen = A.length;
        int BLen = B.length;
        int [][] D = new int[ALen+1][BLen+1];

        for (int i = 1; i <= ALen; i++) {
            for (int j = 1; j <= BLen ; j++) {
                if(A[i-1] == B[j-1]){
                    D[i][j] = D[i-1][j-1] + 1;
                }
                else{
                    D[i][j] = Math.max(D[i-1][j],D[i][j-1]);
                }
            }
        }
        System.out.println(D[ALen][BLen]);
    }
}

