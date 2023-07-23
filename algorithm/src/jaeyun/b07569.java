package algorithm.src.jaeyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b07569 {
	final static int[] dx = {-1, 1, 0, 0, 0, 0};
	final static int[] dy = {0, 0, -1, 1, 0, 0};
	final static int[] dz = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int Z = sc.nextInt();
		int wellDone = 0, emptySpace = 0;
		int[][][] map = new int[Z][Y][X];
		Queue<Pair> q = new LinkedList<>();
		for (int iz=0; iz<Z; iz++) {
			for (int iy=0; iy<Y; iy++) {
				for (int ix=0; ix<X; ix++) {
					map[iz][iy][ix] = sc.nextInt();
					if (map[iz][iy][ix] == 1) {
						wellDone++;
						q.add(new Pair(ix, iy, iz));
					}
					else if (map[iz][iy][ix] == -1) {
						emptySpace++;
					}
				}
			}
		}
		
		int ans = 0;
		while (!q.isEmpty()) {
			int newWellDone = wellDone;
			int qsize = q.size();
			for (int i=0; i<qsize; i++) {
				Pair pair = q.poll();
				for (int d=0; d<6; d++) {
					int nx = pair.x + dx[d];
					int ny = pair.y + dy[d];
					int nz = pair.z + dz[d];
					if (nx<0 || ny<0 || nz<0 || nx>X-1 || ny>Y-1 || nz>Z-1) continue;
					if (map[nz][ny][nx] == 0) {
						q.add(new Pair(nx, ny, nz));
						map[nz][ny][nx] = 1;
						newWellDone++;
					}
				}
			}
			if (wellDone == newWellDone) {
				if (wellDone != X*Y*Z - emptySpace) System.out.println(-1);
				else System.out.println(ans);
				return;
			}
			wellDone = newWellDone;
			ans++;
		}
		System.out.println(-1); // 1*1*1
	}
}

class Pair {
	int x, y, z;
	public Pair(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
