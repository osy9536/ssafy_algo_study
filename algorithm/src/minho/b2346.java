import java.util.*;
import java.io.*;
class Node {
    int key;
    int value;
    public Node(int a, int b){
        this.key = a;
        this.value = b;
    }
}
class b2346 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Node> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1 ; i <= T ; i++){
            Node n = new Node(i,Integer.parseInt(st.nextToken()));
            dq.addLast(n);
        }
        int next = 0;
        int count = 0 ;
        while(!dq.isEmpty()){
            Node node, nextNode;
            if(next == count) {
                nextNode = dq.peekFirst();
                dq.removeFirst();
                next = (nextNode.value>0 ? nextNode.value-1 : nextNode.value);
                count = 0;
                sb.append(nextNode.key+" ");
                continue;
            }
            if(next > 0) {
                count += 1;
                node = dq.peekFirst();
                dq.removeFirst();
                dq.addLast(node);
            }else if (next < 0){
                count -= 1;
                node = dq.peekLast();
                dq.removeLast();
                dq.addFirst(node);
            }
        }
        System.out.println(sb);
    }
}