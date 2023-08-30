import java.util.Scanner;

public class b1976 {
	static int parent[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		parent = new int[N+1]; //부모배열 초기화 
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for(int i = 0; i < N; i++) {		//부모노드
			for(int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				if(temp == 1) {     		//연결되어 있다면
					union(i+1, j+1);
				}
			}
		}
		int plan[] = new int[M]; //여행 계획
		for(int i = 0; i < M; i++) {
			plan[i] = sc.nextInt();
		}
		int start = find(plan[0]);
		boolean check = true;
		for(int i = 1; i < M; i++) {
			if (find(plan[i]) != start) {
				check = false;
			}
		}
		if(check) System.out.println("YES");
		else System.out.println("NO");
	}
	static void union(int i, int j) {
		int parentI = find(i);
		int parentJ = find(j);
		if(parentI == parentJ) return;
		else if(parentI < parentJ) {
			parent[parentJ] = parentI; //작은쪽이 부모가 됨
		}
		else {
			parent[parentI] = parentJ;
		}
	}
	static int find(int i) {
		if(parent[i] == i) return i;
		else return parent[i] = find(parent[i]);
	}
}
