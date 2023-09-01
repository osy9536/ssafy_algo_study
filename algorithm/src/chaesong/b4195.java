import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class b4195 {
	static HashMap<String, Integer> hm; 
	static int parent[] = new int[2000000];
	static int count[] = new int[2000000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			for(int i = 1; i < parent.length; i++) {
				parent[i] = i;
				count[i] = 1;
			}
			hm = new HashMap<>(100000);
			int F = Integer.parseInt(br.readLine());
			for(int f = 0; f < F; f++) {
				st = new StringTokenizer(br.readLine());
				String p1 = st.nextToken();
				String p2 = st.nextToken();
				if(!hm.containsKey(p1)) {
					hm.put(p1, hm.size()+1);
				}
				if(!hm.containsKey(p2)) {
					hm.put(p2, hm.size()+1);
				}
				//a는 p1의 인덱스, b는 p2의 인덱스
				int a = hm.get(p1); int b = hm.get(p2);
				union(a, b);
				bw.write(count[parent[a]]+"\n"); 
				//어짜피 a, b를 유니온 하면
				//a에 노드들이 달릴거니까 count배열에서  parent[a]를 찾아 출력하면 됨
			}
			bw.flush();
		}
		bw.close();
		br.close();
	}
	static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		if(parentA == parentB) return;
		else { //a는 무조건 b보다 작음
			parent[parentB] = parentA;
			count[parentA] += count[parentB];
		}
	}
	static int find(int a) {
		if(a == parent[a]) return a;
		else {
			return parent[a] = find(parent[a]);
		}
	}
}
