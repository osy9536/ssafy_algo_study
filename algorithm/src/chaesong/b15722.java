import java.util.Scanner;

public class b15722 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mx = 0; int my = 0;
		int dx[] = {0, 1, 0, -1};
		int dy[] = {1, 0, -1, 0};
		int delta = 0; int cnt = 0;
		if(n==1) {
			mx += dx[0]; my += dy[0];
		}
		else{
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < i; j++) {
					if (cnt == n) break;
					mx += dx[delta]; my += dy[delta];
					cnt++;
					if (cnt == n) break;
				}
				delta = (delta+1) % 4;
				for(int j = 0; j < i; j++) {
					if (cnt == n) break;
					mx += dx[delta]; my += dy[delta];
					cnt++;
					if (cnt == n) break;
				}
				delta = (delta+1) % 4;
			}			
		}
		System.out.println(mx + " " + my);
	}
}
