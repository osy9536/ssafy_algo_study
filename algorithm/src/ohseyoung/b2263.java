package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2263 {
    static int[] inorder;
    static int[] postorder;
    static int[] inorderIndex;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        inorderIndex = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            inorderIndex[inorder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        getPreorder(0, n - 1, 0, n - 1);
        System.out.println(sb.toString());
    }

    static void getPreorder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        int root = postorder[postEnd];
        sb.append(root).append(" ");

        int rootIndex = inorderIndex[root];
        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - rootIndex;

        getPreorder(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        getPreorder(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}
