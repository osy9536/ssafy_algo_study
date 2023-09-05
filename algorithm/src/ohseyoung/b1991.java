package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리 순회
// silver 1
public class b1991 {
    static class Tree {
        int left, right;

        Tree(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static List<Tree>[] tree;
    static StringBuilder pre;
    static StringBuilder post;
    static StringBuilder inorder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        pre = new StringBuilder();
        post = new StringBuilder();
        inorder = new StringBuilder();
        tree = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = st.nextToken().charAt(0) - 'A';
            int l = st.nextToken().charAt(0) - 'A';
            int r = st.nextToken().charAt(0) - 'A';
            tree[p].add(new Tree(l, r));
        }
        pre(0);
        post(0);
        inorder(0);
        System.out.println(pre.toString());
        System.out.println(inorder.toString());
        System.out.println(post.toString());
    }

    static void pre(int p) {
        int l = tree[p].get(0).left;
        int r = tree[p].get(0).right;
        pre.append(Character.toChars(p + 'A'));
        if (l > 0) {
            pre(l);
        }
        if (r > 0) {
            pre(r);
        }
    }

    static void post(int p) {
        int l = tree[p].get(0).left;
        int r = tree[p].get(0).right;
        if (l > 0) {
            post(l);
        }
        if (r > 0) {
            post(r);
        }
        post.append(Character.toChars(p + 'A'));
    }
    static void inorder(int p) {
        int l = tree[p].get(0).left;
        int r = tree[p].get(0).right;
        if (l > 0) {
            inorder(l);
        }
        inorder.append(Character.toChars(p + 'A'));
        if (r > 0) {
            inorder(r);
        }
    }
}
