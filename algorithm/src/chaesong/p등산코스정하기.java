import java.util.*;

class Solution {
    static ArrayList<Node> ans;
    static ArrayList<Node>[] intensity;
    static boolean[] visited;
    static int[] dist;
    
    static class Node implements Comparable<Node>{
        int x, inten;
        Node(int x, int inten){
            this.x = x;
            this.inten = inten;
        }
        
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.inten, o.inten);
        }
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        intensity = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            intensity[i] = new ArrayList<>();
        }
        for(int[] path: paths){
            int s = path[0];
            int e = path[1];
            int w = path[2];
            
            // 출발점이 gate이거나 도착점이 산봉우리라면
            if(isGate(s, gates) || isSummit(e, summits)){
                intensity[s].add(new Node(e, w));
            }
            // 도착점이 gate이거나 출발점이 산봉우리라면 
            else if(isGate(e, gates) || isSummit(s, summits)){
                intensity[e].add(new Node(s, w));
            }
            else{
                intensity[s].add(new Node(e, w));
                intensity[e].add(new Node(s, w));
            }
        }
        
        return dijkstra(n, gates, summits);
    }
    static int[] dijkstra(int n, int[] gates, int[] summits){
        Queue<Node> q = new LinkedList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int gate: gates){
            q.add(new Node(gate, 0));
            dist[gate] = 0;
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.inten > dist[now.x]) continue;
            
            for(Node nxt: intensity[now.x]){
                int tmp = Math.max(nxt.inten, dist[now.x]);
                if(dist[nxt.x] > tmp){
                    dist[nxt.x] = tmp;
                    q.add(new Node(nxt.x, tmp));
                }
            
            }
        }
        int mn = Integer.MIN_VALUE;
        int mw = Integer.MAX_VALUE;
        
        Arrays.sort(summits);
        for(int summ: summits){
            if(dist[summ] < mw){
                mn = summ;
                mw = dist[summ];
            }
        }
        return new int[]{mn, mw};
    }
    static boolean isGate(int num, int[] gates){
        for(int gate: gates){
            if(num == gate) return true;
        }
        return false;
    }
    static boolean isSummit(int num, int[] submits){
        for(int submit: submits){
            if(num == submit) return true;
        }
        return false;
    }
}
