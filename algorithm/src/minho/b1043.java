package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1043 {

    static ArrayList<Integer>[] party;
    static int N,M;
    static int[] parent;
    static boolean[] know;
    static int find(int x){
        if(parent[x] == x)
            return x;
        parent[x]=find(parent[x]);
        return parent[x]=find(parent[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y) return;
        parent[y]=x;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        know = new boolean[N+1];
        boolean[] isVisited = new boolean[N+1];
        party = new ArrayList[M];
        st = new StringTokenizer(br.readLine());
        int know_people = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < know_people; i++){
            int peo = Integer.parseInt(st.nextToken());
            know[peo] = true;
        }
        for(int i = 0 ; i < N+1;i++)
            parent[i]=i;

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            party[i] = new ArrayList<>();
            int partypeople = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < partypeople ; j++){
                party[i].add(Integer.parseInt(st.nextToken()));
            }
            int size = party[i].size();
            for(int j = 0 ; j < size-1 ; j++){
                int a = party[i].get(j);
                int b = party[i].get(j+1);
                if(find(a)!=find(b))
                    union(a,b);
            }
        }

        for(int i = 1 ; i <= N ; i++){
            if(know[i] && !isVisited[i]){
                int root = find(i);
                for(int j = 1 ; j <= N ; j++){
                    if(find(j)==root){
                        know[j] = true;
                        isVisited[j] = true;
                    }
                }
            }
        }

        int answer = 0 ;
        for(int i = 0 ; i < M ; i++){
            boolean flag = false;
            for (int person : party[i]){
                if(know[person]) {
                    flag = true;
                    break;
                }
            }
            if(!flag) answer++;
        }
        System.out.println(answer);
    }
}