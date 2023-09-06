package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b12891 {
    static int[] min;
    static int[] ans;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        min = new int[4];
        ans = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) {
            char a = str.charAt(i);
            if(a == 'A') ans[0]++;
            if(a == 'C') ans[1]++;
            if(a == 'G') ans[2]++;
            if(a == 'T') ans[3]++;
        }
        if(check()) res++;

        for (int i = 0; i < S-P; i++) {
            char a = str.charAt(i);
            if(a == 'A') ans[0]--;
            if(a == 'C') ans[1]--;
            if(a == 'G') ans[2]--;
            if(a == 'T') ans[3]--;
            char b = str.charAt(i+P);
            if(b == 'A') ans[0]++;
            if(b == 'C') ans[1]++;
            if(b == 'G') ans[2]++;
            if(b == 'T') ans[3]++;
            if (check()) res++;
        }
        System.out.println(res);
    }

    private static boolean check() {
        for (int i = 0; i < 4; i++) {
            if(min[i]>ans[i]) return false;
        }
        return true;
    }
}


