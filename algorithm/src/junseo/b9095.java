package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int [] D = new int[12];
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;

        for (int i = 4; i < 12; i++) {
            D[i] = D[i-1]+ D[i-2] + D[i-3];
        }

        for (int t = 1; t <= T ; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(D[n]).append("\n");
        }

        System.out.println(sb);

    }

}
