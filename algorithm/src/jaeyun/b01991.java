package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b01991 {
	static Node[] nodes;
	static String ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		nodes = new Node[26];
		for (int i=0; i<N; i++) {
			char[] tmp = br.readLine().toCharArray();
			int val = tmp[0] - 'A';
			nodes[val] = new Node();
			if (tmp[2] != '.') nodes[val].left = tmp[2] - 'A';
			if (tmp[4] != '.') nodes[val].right = tmp[4] - 'A';
		}
//		for (int j=0; j<=8; j++) System.out.println("nodes at "+j+": "+nodes[j]);
		ans = "";
		traversal_preorder(0);
		sb.append(ans+"\n");
		ans = "";
		traversal_inorder(0);
		sb.append(ans+"\n");
		ans = "";
		traversal_postorder(0);
		sb.append(ans+"\n");
		System.out.println(sb);
	}
	
	private static class Node {
		int left, right; // from 'A' to 'Z'
		Node() {
			this.left = -1;
			this.right = -1;
		}
//		@Override
//		public String toString() {
//			return "[left: "+left+", right: "+right+"]";
//		}
	}
	
	private static void traversal_inorder(int node) {
		if (nodes[node].left != -1) traversal_inorder(nodes[node].left);
		ans += (char)(node+'A');
		if (nodes[node].right != -1) traversal_inorder(nodes[node].right);
	}
	private static void traversal_preorder(int node) {
		ans += (char)(node+'A');
		if (nodes[node].left != -1) traversal_preorder(nodes[node].left);
		if (nodes[node].right != -1) traversal_preorder(nodes[node].right);
	}
	private static void traversal_postorder(int node) {
		if (nodes[node].left != -1) traversal_postorder(nodes[node].left);
		if (nodes[node].right != -1) traversal_postorder(nodes[node].right);
		ans += (char)(node+'A');
	}
}
