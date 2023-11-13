package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Road{
    int end;
    int val;

    public Road(int end, int val) {
        this.end = end;
        this.val = val;
    }
}
public class b1167 {
    static int N ,max = 0 ,x;
    static ArrayList<Road>[] list;
    static boolean[] isVisited;
    static void DFS(int current, int length){
        if(max < length){
            x = current;
            max = length;
        }
        isVisited[current] = true;
        for (Road next : list[current] ) {
            if(isVisited[next.end]) continue;
            DFS(next.end,next.val+length);
            isVisited[next.end] = true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        isVisited = new boolean[N+1];

        for(int i = 1 ; i <= N ; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int a = Integer.parseInt(st.nextToken());
                if(a==-1) break;
                int b = Integer.parseInt(st.nextToken());
                list[s].add(new Road(a,b));
            }
        }
        DFS(1,0);
        isVisited = new boolean[N+1];
        DFS(x,0);
        System.out.println(max);
    }
}