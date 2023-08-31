package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b11725 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        boolean[] visit = new boolean[n+1];
        int[] result = new int[n+1];
        
        /*
         * 1까지 가는 길을 찾아, 거기서 바로 다음 거를 답으로
         */
        
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            
            tree.get(one).add(two);
            tree.get(two).add(one);
            
        }
        
        
        Queue<Integer> que = new LinkedList<Integer>();
        for (int i = 0; i < tree.get(1).size(); i++) {
        	int son = tree.get(1).get(i);
            que.add(son);
            result[son] = 1;
            visit[son] = true;
        }
        while (!que.isEmpty()) {
        	int now = que.poll();
        	for (int i = 0; i < tree.get(now).size(); i++) {
				int son = tree.get(now).get(i);
				if (visit[son]) continue;
				result[son] = now;
				que.add(son);
				visit[son] = true;
			}
        }
        
        for (int i = 2; i <= n; i++) {
            System.out.println(result[i]);
        }
    }
}
