package algorithm.jisu;

import java.util.Scanner;

public class b13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] students = new int[n][2];
		int[] room = new int[1001];
		int[] roomnums = new int[12];
		
		int totalridx = 0;
		int checkzero = 0;
		
		for (int i = 0; i < n; i++) {
			students[i][0] = sc.nextInt();
			students[i][1] = sc.nextInt();
		}
		
		
		for (int i = 0; i < students.length; i++) {
			int studentcondition = (students[i][1]-1) * 2 + students[i][0];
			int ridx = roomnums[studentcondition];
			if (room[ridx] >= k || (ridx == 0)) {
				totalridx++;
				roomnums[studentcondition] = totalridx;
				ridx = totalridx;
			}
			room[ridx]++;
		}
		
		
		System.out.println(totalridx);
	}
}
