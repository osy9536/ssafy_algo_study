import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
 
public class Solution {
    static int N; static int K;
    static String s;
    static StringBuilder sb;
    static HashSet<String> ans;
    static Deque<String> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            s = br.readLine();
            ans = new HashSet<>();
            q = new ArrayDeque<>();
            for(int i = 0; i < N/4; i++) {
                circle(i);
            }
            Iterator<String> iter = ans.iterator();
            //PriorityQueue<Integer> result = new PriorityQueue<>((a, b)->(b-a));
            Integer result[] = new Integer[ans.size()];
            int idx = 0;
            while(iter.hasNext()) {
                int temp = Integer.parseInt(iter.next(), 16);
                result[idx] = temp;
                idx++;
            }
            Arrays.sort(result, Collections.reverseOrder());
            System.out.println("#"+t+" "+result[K-1]);
        }
    }
    static void circle(int n) {
        for(int i = 0; i < N-n; i++) {
            q.add(s.substring(i, i+1));
        }
        for(int i = 0; i < n; i++) {
            q.addFirst(s.substring(N-1-i, N-i));
        }
        for(int i = 0; i < N; i += N/4) {
            sb = new StringBuilder();
            for(int j = i; j < i+N/4; j++) {
                sb.append(q.poll());
            }
            ans.add(sb.toString());
        }
    }
}
