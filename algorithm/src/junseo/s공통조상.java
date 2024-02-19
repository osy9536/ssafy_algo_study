import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class s공통조상 {

    static List<Integer> aAncestor;
    static List<Integer> bAncestor;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder  sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T ; t++) {
            int V,E,A,B;
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            nodes = new Node[V+1];
            for (int i = 0; i < V + 1; i++) {
                nodes[i] = new Node();
            }

            st = new StringTokenizer(br.readLine());

            while(st.hasMoreElements()){
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                nodes[child].parent = parent;
                nodes[parent].child.add(child);
            }


            aAncestor = new ArrayList<>();
            bAncestor = new ArrayList<>();

            findAncestor(A, aAncestor);
            findAncestor(B, bAncestor);

            int ans = 0;

            for (int i = 0; i < V ; i++) {
                if(!aAncestor.get(i).equals(bAncestor.get(i))) break;
                ans = aAncestor.get(i);
            }

            sb.append("#").append(t).append(" ").append(ans).append(" ").append(dfs(ans)).append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int idx) {
        int res = 1;
        for (int child : nodes[idx].child) {
            res += dfs(child);
        }
        return res;
    }

    private static void findAncestor(int cur, List<Integer> ancestor) {

        if(nodes[cur].parent != 0) findAncestor(nodes[cur].parent,ancestor);
        ancestor.add(cur);
    }

    public static class Node {
        List<Integer> child = new ArrayList<>();
        int parent;
        Node(){
            parent = 0;
        }

    }
}

