package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 개미굴
// gold 3
public class b14725 {
    
    static class Node {
        Map<String, Node> childNode = new HashMap<>();
        boolean endOfWord;
    }

    static class Trie {
        Node rootNode = new Node();

        void insert(String[] str) {
            Node node = this.rootNode;
            for (String s : str) {
                node = node.childNode.computeIfAbsent(s, key -> new Node());
            }
            node.endOfWord = true;
        }

        void print(Node cur, int depth) {

            if (cur.childNode != null) {
                List<String> list = new ArrayList<>(cur.childNode.keySet());
                Collections.sort(list);
                for (String str : list) {
                    for (int i = 0; i < depth; i++) {
                        System.out.print("--");
                    }
                    System.out.println(str);
                    print(cur.childNode.get(str),depth+1);
                }
            }
        }
    }

    static List<String>[] foods;
    static Trie trie;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        foods = new List[n];
        trie = new Trie();

        for (int i = 0; i < n; i++) {
            foods[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String[] arr = new String[k];
            for (int j = 0; j < k; j++) {
                String c = st.nextToken();
                foods[i].add(c);
                arr[j] = c;
            }
            trie.insert(arr);
        }

        trie.print(trie.rootNode, 0);
    }
}
