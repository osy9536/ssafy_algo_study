package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 지름길
// silver 1
public class b1446 {
    static class Node implements Comparable<Node>{
        int start, end, distance;

        Node(int start, int end, int distance) {
            this.distance = distance;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if(this.start==o.start){
                return this.end - o.end;
            }
            return this.start-o.start;
        }
    }

    static List<Node> nodes;
    static int n, d;
    static int result = Integer.MAX_VALUE;
    static boolean [] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());


        nodes = new ArrayList<>();

        int start,end, distance;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());
            if(end> d){
                continue;
            }
            nodes.add(new Node(start,end,distance));
        }

        check = new boolean[nodes.size()];
        dfs(0, d,0);

        System.out.println(result);
    }

    private static void dfs(int now, int end, int distance){
        if(now>end){
            return;
        }
        else if(now==end){
            result= Math.min(result,distance);
            return;
        }
        else{
            result = Math.min(result, distance+(end-now));
        }

        for(int i = 0; i< nodes.size(); i++){
            if(!check[i]){
                Node node = nodes.get(i);
                if(node.start==now){
                    check[i]=true;
                    dfs(node.end, d, distance+ node.distance);
                    check[i]=false;
                }
            }
        }
        dfs(now+1, d, distance+1);
    }
}
