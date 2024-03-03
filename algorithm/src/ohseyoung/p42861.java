package ohseyoung.a0303;

import java.util.Arrays;

// 섬 연결하기
// 프로그래머스 42861
class p42861 {

    public static void main(String[] args) {
        
    }

    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }

        Arrays.sort(costs, (o1,o2)->(o1[2]-o2[2]));
        for(int i = 0 ; i<costs.length; i++){
            if(find(costs[i][0])!=find(costs[i][1])){
                union(costs[i][0], costs[i][1]);
                answer+=costs[i][2];
            }
        }

        return answer;
    }

    public static int find(int a){
        if(a==parent[a]){
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){
        int na = find(a);
        int nb = find(b);

        if(na!=nb){
            parent[nb] = na;

        }
    }
}
