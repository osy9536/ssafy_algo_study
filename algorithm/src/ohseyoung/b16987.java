package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 계란으로 계란치기
// gold 5
public class b16987 {
	static class Egg {
		int s, w;

		Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}
	}

	static Egg[] eggs;
	static int n, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		eggs = new Egg[n];
		ans = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(s, w);
		}
		permu(0);
		System.out.println(ans);
	}

	static void permu(int depth) {
		if (depth == n) {
			solve();
			return;
		}

		if (eggs[depth].s <= 0) {
			permu(depth + 1);
		} else {
			boolean allBroken = true;
			for (int i = 0; i < n; i++) {
				if (i != depth && eggs[i].s > 0) {
					allBroken = false;
					break;
				}
			}
			if (allBroken) {
				ans = Math.max(ans, n - 1);
			} else {
				for (int i = 0; i < n; i++) {
					if (i != depth && eggs[i].s > 0) {
						eggs[depth].s -= eggs[i].w;
						eggs[i].s -= eggs[depth].w;
						permu(depth + 1);
						eggs[depth].s += eggs[i].w;
						eggs[i].s += eggs[depth].w;
					}
				}
			}
		}
	}

	static void solve() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (eggs[i].s <= 0) {
				cnt++;
			}
		}
		ans = Math.max(ans, cnt);
	}
}

