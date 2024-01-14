package Boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Node{
    int end;
    int val;
    public Node(int end, int val) {
        this.end = end;
        this.val = val;
    }
}
public class b14938 {
    static int N, M, R, ans, answerMax=Integer.MIN_VALUE;
    static int[] item;
    static ArrayList<Node>[] list;
    static boolean[] isVisited;
    static boolean[] checked;
    public static void DFS(int sum,int now){
        for(Node next : list[now]){
            if (!isVisited[next.end] && sum+next.val<=M){
                isVisited[next.end] = true;
                if(!checked[next.end]) {
                    checked[next.end]=true;
                    ans += item[next.end];
                }
                DFS(sum+next.val, next.end);
                isVisited[next.end] = false;
            }
        }
        return;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        item = new int[N+1];
        list = new ArrayList[N+1];
        st= new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<=N; i++) {
            list[i] = new ArrayList<Node>();
        }
        for(int i = 0 ; i < R ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,l));
            list[b].add(new Node(a,l));
        }
        for(int i = 1; i <= N; i++){
            isVisited = new boolean[N+1];
            checked = new boolean[N+1];
            ans = item[i];
            checked[i]=true;
            DFS(0,i);
            if(answerMax<ans) answerMax = ans;
        }
        System.out.println(answerMax);
    }
}
