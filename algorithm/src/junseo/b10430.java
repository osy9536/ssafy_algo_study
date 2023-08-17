package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10430_나머지 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());		
		int A = Integer.parseInt(st.nextToken());		
		int B = Integer.parseInt(st.nextToken());		
		int C = Integer.parseInt(st.nextToken());
		
		sb.append((A+B)%C).append("\n").append(((A%C)+(B%C))%C).append("\n")
		.append((A*B)%C).append("\n").append(((A%C)*(B%C))%C);
		System.out.println(sb);
	}

}

