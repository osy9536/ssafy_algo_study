package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단경로
// gold 4
public class b1753 {
	static class Edge implements Comparable<Edge>{
	    int end, weight;

	    public Edge(int end, int weight){
	        this.end = end;
	        this.weight = weight;
	    }

	    @Override
	    public int compareTo(Edge o) {
	        return weight - o.weight;
	    }
	}
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int v,e,k;
    static List<Edge>[] list;
    static int[] minEdge;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        minEdge = new int[v + 1];

        Arrays.fill(minEdge, Integer.MAX_VALUE);

        for(int i = 1; i <= v; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(end, weight));
        }

        StringBuilder sb = new StringBuilder();
        bfs(k);
        for(int i = 1; i <= v; i++){
            if(minEdge[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(minEdge[i] + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void bfs(int start){
    	// 정렬
       PriorityQueue<Edge> queue = new PriorityQueue<>();
       boolean[] visited = new boolean[v + 1];
       queue.add(new Edge(start, 0));
       minEdge[start] = 0;

       while(!queue.isEmpty()){
           Edge curNode = queue.poll();
           int cur = curNode.end;

           if(visited[cur]) continue;
           visited[cur] = true;

           for(Edge e : list[cur]){
               if(minEdge[e.end] > minEdge[cur] + e.weight){
                   minEdge[e.end] = minEdge[cur] + e.weight;
                   queue.add(new Edge(e.end, minEdge[e.end]));
               }
           }
       }
    }
}
