import java.util.Scanner;

public class b1068 {
	static int N;
	static int[] tree;
	static boolean[] visit;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		int root = 0;
		tree = new int[N];
		for(int i = 0; i < N; i++) {
			tree[i] = sc.nextInt();
			if(tree[i] == -1) root = i;
		}
		int n = sc.nextInt();
		delete(n);
		visit = new boolean[N];
		cnt = 0;
		leaf(root);
		System.out.println(cnt);
	}
	static void delete(int n) {
		tree[n] = -2; //삭제한 노드 -2로 표시
		for(int i = 0; i < N; i++) {
			if(tree[i] == n) {
				delete(i);
			}
		}
	}
	static void leaf(int r) {
		boolean isLeaf = true;
		visit[r] = true;
		if(tree[r] != -2) {
			for(int i = 0; i < N; i++) {
				if(tree[i] == r && visit[i] == false) {
					leaf(i);
					isLeaf = false; //부모노드는 Leaf가 아니니까
				}
			}
			if(isLeaf) cnt++;
		}
	}
}
