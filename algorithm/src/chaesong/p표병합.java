import java.util.*;

class Solution{
    static final int cellSize = 50;
    static final int boardSize = cellSize * cellSize;
    static final String empty = "EMPTY";
    
    static int[] rank;
    static int[] parent;
    static String[] board;
    
    // 부모 초기화
    static void init(){
        rank = new int[boardSize];
        parent = new int[boardSize];
        board = new String[boardSize];
        
        for(int i = 1; i < boardSize; i++){
            parent[i] = i;
        }
    }
    
    static int find(int r, int c){
        return find(cellSize*r+c);
    }
    
    static int find(int n){
        if(parent[n] == n){
            return n;
        }
        parent[n] = find(parent[n]);
        return parent[n];
    }
    
    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa == pb){
            return;
        }
        if(rank[pa] < rank[pb]){
            parent[pa] = pb;
            if(board[pa] != null){
                board[pb] = board[pa];
                board[pa] = null;
            }
        }else{
            parent[pb] = pa;
            if(rank[pa] == rank[pb]){
                rank[pa]++;
            }
            if(board[pa] == null){
                board[pa] = board[pb];
                board[pb] = null;
            }
        }
    }
    
    static void dismiss(int a){
        for(int i = 0; i < boardSize; i++){
            find(i);
        }
        int x = find(a);
        String temp = board[x];
        for(int i = 0; i < boardSize; i++){
            int y = find(i);
            if(x == y){
                rank[i] = 0;
                parent[i] = i;
                board[i] = null;
            }
        }
        board[a] = temp;
    }
    
    static void update(String value1, String value2){
        for(int i = 0; i < boardSize; i++){
            if(board[i] != null && board[i].equals(value1)){
                board[i] = value2;
            }
        }
    }
    
    static void update(int r, int c, String value){
        int n = find(cellSize*r + c);
        board[n] = value;
    }
    
    static void merge(int r1, int c1, int r2, int c2){
        union(cellSize*r1+c1, cellSize*r2+c2);
    }
    
    static void unmerge(int r, int c){
        dismiss(cellSize*r+c);
    }
    
    static String print(int r, int c){
        int n = find(cellSize*r+c);
        if(board[n] == null){
            return empty;
        }
        return board[n];
    }
    
    public void command(String comm, List<String> list){
        String[] comms = comm.split(" ");
        String commName = comms[0];
        
        if(commName.equals("UPDATE")){
            if(comms.length == 3){
                String value1 = comms[1];
                String value2 = comms[2];
                update(value1, value2);
            }else{
                int r = Integer.parseInt(comms[1])-1;
                int c = Integer.parseInt(comms[2])-1;
                String value = comms[3];
                update(r, c, value);
            }
        }else if(commName.equals("MERGE")){
            int r1 = Integer.parseInt(comms[1])-1;
            int c1 = Integer.parseInt(comms[2])-1;
            int r2 = Integer.parseInt(comms[3])-1;
            int c2 = Integer.parseInt(comms[4])-1;
            merge(r1, c1, r2, c2);
        }else if(commName.equals("UNMERGE")){
            int r = Integer.parseInt(comms[1])-1;
            int c = Integer.parseInt(comms[2])-1;
            unmerge(r, c);
        }else if(commName.equals("PRINT")){
            int r = Integer.parseInt(comms[1])-1;
            int c = Integer.parseInt(comms[2])-1;
            list.add(print(r, c));
        }
    }
    
    public String[] solution(String[] commands){
        List<String> list = new ArrayList<String>(1000);
        init();
        
        for(String command: commands){
            command(command, list);
        }
        
        String[] answer = new String[list.size()];
        int i = 0;
        for(String s: list){
            answer[i++] = s;
        }
        return answer;
    }
}
