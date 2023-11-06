import java.util.*;
import java.io.*;
public class b1405 {
	static int arr[][];
	static int n;
	static double east, west, south, north;
	static double ans;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		arr = new int[50][50];
		n = sc.nextInt();
		east = sc.nextDouble()/100;
		west = sc.nextDouble()/100;
		south = sc.nextDouble()/100;
		north = sc.nextDouble()/100;
		arr[15][15] = 1;
		ans = 0;
		dfs(0, 15, 15, 1);
		System.out.print(ans);
	}
	static void dfs(int depth, int x, int y, double percent) {
		if(depth == n) {
			ans += percent;
			return;
		}
		if(arr[x+1][y] == 0) {
			arr[x+1][y] = 1;
			dfs(depth+1, x+1, y, percent*south);
			arr[x+1][y] = 0;
		}
		if(arr[x-1][y] == 0) {
			arr[x-1][y] = 1;
			dfs(depth+1, x-1, y, percent*north);
			arr[x-1][y] = 0;
		}
		if(arr[x][y+1] == 0) {
			arr[x][y+1] = 1;
			dfs(depth+1, x, y+1, percent*east);
			arr[x][y+1] = 0;
		}
		if(arr[x][y-1] == 0) {
			arr[x][y-1] = 1;
			dfs(depth+1, x, y-1, percent*west);
			arr[x][y-1] = 0;
		}
	}
}
