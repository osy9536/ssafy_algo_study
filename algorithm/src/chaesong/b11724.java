import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b11724 {
	//�鷶���� �ȵ鷶���� Ȯ���Ϸ���
	static boolean visited[];
	//��� �迭
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		//��� ����
		int N = Integer.parseInt(st.nextToken());
		//���� ����
		int M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i < N+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		//����������ŭ ���鼭 ����Ʈ�� �־��ֱ�
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[b].add(a);
			A[a].add(b); //����� ����̴ϱ� �Ѵ� �־���� ��
		}
		int cnt = 0;
		for(int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				cnt++;
				DFS(i);
			}
		}
		System.out.println(cnt);
		
	}
	static void DFS(int v) {
		//�湮�ߴٸ�
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		for(int i : A[v]) {
			if(visited[i] == false) {
				DFS(i);
			}
		}
	}
}
