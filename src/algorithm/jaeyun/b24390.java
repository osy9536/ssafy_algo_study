package algorithm.jaeyun;

import java.util.Scanner;

public class b24390 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] time = sc.next().split(":");
		int min = Integer.parseInt(time[0]);
		int sec = Integer.parseInt(time[1]);
		int ans = solution(min * 60 + sec);
		System.out.println(ans);
//		for (int i=10; i<=3600; i+=10) {
//			System.out.println(i/60+":"+i%60+"\t"+solution(i));
//		}
		sc.close();
	}
	public static int solution(int time) {
		int t = time;
		int adder = 0;
		if (t % 600 == 0) return (t / 600) + 1;
		
		while (t > 600) {
			adder += 1;
			t -= 600;
		}
		while (t > 60) {
			adder += 1;
			t -= 60;
		}
		
		if (t == 10) return 2+adder;
		else if (t == 20) return 3+adder;
		else if (t == 30) return 1+adder;
		else if (t == 40) return 2+adder;
		else if (t == 50) return 3+adder;
		else if (t == 60) return 2+adder;
		else return -1;
	}
}

// 10: 10, 시작						2
// 20: 10, 10, 시작					3
// 30: 시작							1
// 40: 시작, 10초						2
// 50: 시작, 10초, 10초					3
// 60: 1분, 시작						2

// 70: 1분, 10, 시작					3
// 80: 1분, 10, 10, 시작				4
// 90: 시작, 1분						2
// 100: 시작, 1분, 10초					3
// 110: 시작, 1분, 10초, 10초			4
// 120: 1분, 1분, 시작					3 (또는 시작, 시작, 1분)

// 130: 1분, 1분, 10초, 시작			4
// 140: 1분, 1분, 10초, 10초, 시작		5 (또는 시작, 1분, 시작, 10초, 10초)
// 150: 시작, 1분, 1분					3
// 160: 시작, 1분, 1분, 10초			4
// 170: 시작, 1분, 1분, 10초, 10초		5
// 180: 1분, 1분, 1분, 시작				4 (또는 시작, 시작, 1분, 1분)

// 190: 1분, 1분, 1분, 10초, 시작		5
// 200: 1분, 1분, 1분, 10초, 10초, 시작	6
// 210: 시작, 1분, 1분, 1분				4
// 220: 시작, 1분, 1분, 1분, 10초		5
// 230: 시작, 1분, 1분, 1분, 10초, 10초	6
// 240: 1분, 1분, 1분, 1분, 시작			5

// Test Cases
// 14분00초: 10분, 1분, 1분, 1분, 1분, 시작
// 14분00초: 시작, 시작, 10분, 1분, 1분, 1분
// 14분50초: 시작, 10분, 1분, 1분, 1분, 1분, 10초, 10초
// 24분50초: 시작, 10분, 10분, 1분, 1분, 1분, 1분, 10초, 10초
// 10분00초: 10분, 시작 -> 10*60 = 600 -> 예외처리
// 29분50초: 시작, 10분, 10분, 1분(9번), 10초, 10초
