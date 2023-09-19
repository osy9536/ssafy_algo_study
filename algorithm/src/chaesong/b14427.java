import java.io.*;
import java.util.StringTokenizer;

public class b14427 {
    static int[] arr;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        tree = new int[N*4];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(1, N, 1);
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[b] = c;
                update(1, N, 1, b);
            }else{
                bw.write(tree[1]+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static int init(int start, int end, int node){
        if(start == end){
            return tree[node] = start;
        }
        int mid = (start+end) / 2;
        return tree[node] = minIndex(init(start, mid, node*2), init(mid+1, end, node*2+1));
    }
    public static int minIndex(int x, int y){
        if(arr[x] == arr[y]){
            return Math.min(x, y);
        }else{
            return arr[x] < arr[y]? x : y;
        }
    }
    //start: 시작 인덱스, end: 끝 인덱스
    //idx: 수정하고자 하는 노드
    public static int update(int start, int end, int node, int idx){
        if(start > idx || end < idx){ //범위 밖에 있는 경우
            return tree[node];
        }
        if(start == end) {
            return tree[node] = idx;
        }
        //범위 안에 있으면 내려가며 다른 원소도 갱신
        int mid = (start+end) / 2;
        return tree[node] = minIndex(update(start, mid, node*2, idx), update(mid+1, end, node*2+1, idx));
    }
}
