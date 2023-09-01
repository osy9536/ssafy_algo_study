import java.util.ArrayList;
import java.util.Scanner;

public class b1043 {
	static int parent[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//참가하는 사람
		parent = new int[N+1]; 	//부모배열 초기화
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		int M = sc.nextInt();		//파티의 수
		int knowNum = sc.nextInt(); //진실을 아는 사람 수
		int know[] = new int[knowNum];	
		for(int i = 0; i < knowNum; i++) {
			know[i] = sc.nextInt();
		}
		int person[] = new int[N+1];
		ArrayList<int[]> party = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			int people = sc.nextInt();
			int inParty[] = new int[people];
			for(int j = 0; j < people; j++) {
				inParty[j] = sc.nextInt();
			}
			party.add(inParty);
			for(int j = 1; j < people; j++) {
				union(inParty[j-1], inParty[j]);
			}
		}
		int ans = 0;
		for(int i = 0; i < party.size(); i++) {
			boolean check = true;
			for(int j = 0; j < knowNum; j++) {
				if(find(know[j]) == find(party.get(i)[0])) check = false;
			}
			if(check) ans++;
		}
		System.out.println(ans);
	}
	static void union(int i, int j) {
		int parentI = find(i);
		int parentJ = find(j);
		if(parentI == parentJ) return;
		else if(parentI < parentJ) {	//좀 더 작은 쪽으로 연결
			parent[parentJ] = parentI; 
		}else {
			parent[parentI] = parentJ;
		}
	}
	static int find(int i) {
		if (parent[i] == i) return i;
		else return parent[i] = find(parent[i]);
	}
}
