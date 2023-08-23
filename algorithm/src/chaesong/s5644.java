import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea_charge {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	private static int T;
	private static int M; // 총 이동시간
	private static int BC; // 충전기 개수
	private static User[] p1, p2; // a, b의 이동경로
	private static BatteryCharger[] spots;

	static int move[][] = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static int power;

	public static void main(String args[]) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 이동시간
			BC = Integer.parseInt(st.nextToken()); // 충전기 개수

			// User에는 열, 행, 시간, 가능한 충전기가 저장
			// p1[i]에는 i시간에 어디에 위치하고 가능한 충전기가 어떤건지 저장됨
			p1 = new User[M + 1]; // 인덱스에 해당하는 시간에 user가 어디에 위치해 있는지를 저장
			p2 = new User[M + 1]; // M이 1부터 시작하니까 user 배열의 크기는 M+1

			p1[0] = new User(1, 1, 0); // 처음위치는 (1, 1)에서 시작, 시간은 0
			p2[0] = new User(10, 10, 0);

			updateMovePath(new StringTokenizer(br.readLine()), p1); // 위치와 시간을 업데이트
			updateMovePath(new StringTokenizer(br.readLine()), p2);

			spots = new BatteryCharger[BC]; // 배터리의 정보들을 담아줄 장소
			for (int i = 0; i < BC; i++) { // 배터리 개수만큼 반복하변서
				st = new StringTokenizer(br.readLine());
				// spots[i]는 i번째 배터리 정보를 저장하고 있음
				spots[i] = new BatteryCharger(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()); // 행, 열,
																												// 충전거리,
																												// 충전량
																												// 저장
			}

			// user에 가능한 충전 정보를 저장
			checkSpot(p1);
			checkSpot(p2);

			power = 0; // 구하고자 하는 최댓값
			for (int i = 0; i <= M; i++) {
				BatteryCharger bca = p1[i].charger.poll(); // i시간에 p1이 가능한 충전기
				BatteryCharger bcb = p2[i].charger.poll(); // 존재하지 않는다면 null 반환

				if (bca == null && bcb == null)
					continue; // 둘다 충전할 수 없다면
				// 하나만 가능하다면
				else if (bca == null && bcb != null)
					power += bcb.power;
				else if (bca != null && bcb == null)
					power += bca.power;

				// 둘다 충전 가능한 경우
				else {
					// 둘다 같은 충전기를 사용가능하다면
					if (bca.equals(bcb)) {
						// 나눠쓰더라도 어짜피 합하면 하나임
						power += bca.power;

						// 두번째 거를 비교
						BatteryCharger bca2 = p1[i].charger.poll();
						BatteryCharger bcb2 = p2[i].charger.poll();

						// 둘다 가능한 충전기가 더 있었다면
						if (bca2 != null && bcb2 != null) {
							// 큰 거 더해주기
							power += Math.max(bca2.power, bcb2.power);
						} else {
							if (bca2 == null) {
								if (bcb2 == null) {
									power += 0;
								} else {
									power += bcb2.power;
								}
							} else {
								if (bcb2 == null) {
									power += bca2.power;
								} else {
									power += Math.max(bca2.power, bcb2.power);
								}
							}
						}
					}
					// 다른 충전기를 쓴다면
					else {
						power += bca.power + bcb.power;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(power).append("\n");
		}
		System.out.println(sb);
	}

	// user를 움직이면서 위치와 시간을 업데이트
	private static void updateMovePath(StringTokenizer st, User[] users) {
		// 이동변화는 M만큼 주어짐
		for (int i = 1; i <= M; i++) {
			int dir = Integer.parseInt(st.nextToken());
			User prev = users[i - 1]; // 그 전 위치
			users[i] = new User(prev.row + move[dir][0], prev.col + move[dir][1], i);
		}
	}

	// 가능한 충전기인지 확인
	private static void checkSpot(User[] users) {
		for (int i = 0; i <= M; i++) {
			// user에 i번째 시간에 어떤 충전기를 사용할 수 있는지를 저장
			User user = users[i];
			for (BatteryCharger spot : spots) {
				if (spot.canCharge(user)) {
					// user의 charger는 우선순위 큐
					user.charger.offer(spot); // 충전기 파워가 가장 센 것이 제일 앞에 위치
				}
			}
		}
	}

	// 유저들의 정보를 저장 행, 열, 시간, 가능한 충전기
	static class User {
		int row, col, time;
		PriorityQueue<BatteryCharger> charger;

		public User(int row, int col, int time) {
			super();
			this.row = row;
			this.col = col;
			this.time = time;
			this.charger = new PriorityQueue<>();
		}
	}

	// 배터리 충전기 정보를 저장 행, 열, 충전 거리, 충전량
	static class BatteryCharger implements Comparable<BatteryCharger> {
		int row, col, dist, power;

		public BatteryCharger(String col, String row, String dist, String power) {
			this.row = Integer.parseInt(row);
			this.col = Integer.parseInt(col);
			this.dist = Integer.parseInt(dist);
			this.power = Integer.parseInt(power);
		}

		// 충전 가능한지 체크
		public boolean canCharge(User user) {
			return (Math.abs(row - user.row) + Math.abs(col - user.col)) <= dist;
		}

		// 가장 파워가 센 충전기 순으로 정렬
		@Override
		public int compareTo(swea_charge.BatteryCharger o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.power, power);
		}
	}
}
