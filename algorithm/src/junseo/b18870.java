package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class b18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] origin = new int[N];
        int [] sorted = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        Map<Integer,Integer> rankingMap = new HashMap<>();
        int rank = 0;
        for (int r: sorted) {
            if(!rankingMap.containsKey(r)){
                rankingMap.put(r,rank);
                rank++;
            }
        }

        for (int key: origin
             ) {
            int a = rankingMap.get(key);
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}



