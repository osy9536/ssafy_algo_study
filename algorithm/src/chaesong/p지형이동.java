import java.util.*;

class Solution {
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int[] parent;
    private static int[][] check;
    private static ArrayList<Node> list;
    // bfs 탐색용
    private static class Dot{
        int x, y;
        Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    // 서로다른 구역과 그 차이를 저장
    private static class Node{
        int a, b, diff;
        Node(int a, int b, int diff){
            this.a = a;
            this.b = b;
            this.diff = diff;
        }
    }
    private static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    public int solution(int[][] land, int height) {

        int answer = 0;
        int len = land.length;
        
        check = new int[len][len];
        for(int i = 0; i < len; i++) Arrays.fill(check[i], 0);
        
        list = new ArrayList<>();
        int area = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                // 이미 구역이 정해졌다면
                if(check[i][j] >= 1) continue;
                
                area++;
                Queue<Dot> q = new LinkedList<>();
                q.add(new Dot(i, j));
                check[i][j] = area; 
                while(!q.isEmpty()){
                    Dot temp = q.poll();
                    for(int k = 0; k < 4; k++){
                        int nx = temp.x + dir[k][0];
                        int ny = temp.y + dir[k][1];
                        if(0 <= nx && nx < len && 0 <= ny && ny < len){
                            if(check[nx][ny] == 0 && Math.abs(land[nx][ny]-land[temp.x][temp.y]) <= height){
                                check[nx][ny] = area;
                                q.add(new Dot(nx, ny));
                            }
                        }
                    }
                }
            }
        }
        
        parent = new int[area+1];
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                for(int k = 0; k < 4; k++){
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];
                    if(0 <= nx && nx < len && 0 <= ny && ny < len){
                        if(check[i][j] == check[nx][ny]) continue;
                        list.add(new Node(check[i][j], check[nx][ny], Math.abs(land[i][j]-land[nx][ny])));
                    }
                }
            }
        }
        
        Collections.sort(list, (o1, o2)->{
            return o1.diff - o2.diff;
        });
        
        int cnt = 0;
        for(Node node: list){
            if(find(node.a) != find(node.b)){
                union(node.a, node.b);
                answer += node.diff;
                if(++cnt == area) break;
            }
        }
        return answer;
    }
    
}
