package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b11725 {

    static int N;
    static ArrayList<Integer>[] list;
    static int[] answer;
    static boolean[] isVisited;

    static void DFS(int s){
        for (int e:list[s]){
            if(isVisited[e]) continue;
            else {
                isVisited[e] = true;
                answer[e] = s;
                DFS(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        answer = new int[N+1];
        isVisited= new boolean[N+1];
        isVisited[1]= true;
        list = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++){
            list[i]=new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        DFS(1);
        for(int i = 2 ; i <= N ; i++){
            sb.append(answer[i]+"\n");
        }
        System.out.println(sb);
    }
}