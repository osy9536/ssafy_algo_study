package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b15961 {
	
	static int N,d,k,c; //접시의수, 초밥의 가짓수, 연속해서 먹는 접시의 수, 쿠폰 번호
	static int[] arr; //회전 초밥 벨트
	static int[] visited; //선택된 초밥 번호
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d= Integer.parseInt(st.nextToken());
		k= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		
		arr = new int [N+k];
		visited = new int[d+1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < k; i++) {
			arr[N+i] = arr[i];
		}
		///////////////////////////////////////////////////////////////
		//처음 한번 d까지의 초밥 개수를 구하고 
		//1씩 증가하면 처음의 초밥 번호를 빼고,뒤에 번호를 넣음 
		int cnt = 1;
		for (int i = 0; i < k; i++) {
			if(visited[arr[i]]==0&&arr[i] != c) cnt++;
			visited[arr[i]]++;
		}
		int res = cnt;
		for (int i = 0; i < N; i++) {
			if(--visited[arr[i]] == 0) {
				if(arr[i] == c) cnt++;
				cnt--;
			}
			if(visited[arr[i+k]] == 0&&arr[i+k] != c) cnt++;
			visited[arr[i+k]]++;
			
			res = Math.max(res, cnt);
//			System.out.println(Arrays.toString(visited));
//			System.out.println(res);
		}
		System.out.println(res);
		
	}

}

