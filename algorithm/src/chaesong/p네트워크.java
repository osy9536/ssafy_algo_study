import java.util.*;

class Solution {
    static int parent[];
    public int solution(int n, int[][] computers) {
        if(n==1) return 1;
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && computers[i][j] == 1){
                    union(i, j);
                }
            }
        } 
        for(int i = 0; i < n; i++){
            parent[i] = find(i);
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < n; i++){
            hs.add(parent[i]);
        }
        
        return hs.size();
    }
    static int find(int n){
        if(n == parent[n]) return n;
        else{
            return parent[n] = find(parent[n]);
        }
    }
    static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA == parentB) return;
        if(parentA < parentB){
            parent[parentB] = parentA;
        }else{
            parent[parentA] = parentB;
        }
    }
}
