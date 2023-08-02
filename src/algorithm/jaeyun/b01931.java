package algorithm.jaeyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Meeting {
	private int s, t;
	public Meeting(int a, int b) {
		this.s = a;
		this.t = b;
	}
	public int getS() {
		return s;
	}
	public int getT() {
		return t;
	}
}

class MeetingSortAxis1 implements Comparator<Meeting> {
	@Override
	public int compare(Meeting o1, Meeting o2) {
		return o1.getS() - o2.getS();
	}
}
class MeetingSortAxis2 implements Comparator<Meeting> {
	@Override
	public int compare(Meeting o1, Meeting o2) {
		return o1.getT() - o2.getT();
	}
}

public class b01931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Meeting> meetings = new ArrayList<>();
		for (int i=0; i<N; i++) {
			meetings.add(new Meeting(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(meetings, new MeetingSortAxis1());
		Collections.sort(meetings, new MeetingSortAxis2());
        int end = meetings.get(0).getT();
        int cnt = 1;
		for (int i=1; i<N; i++) {
            if (end <= meetings.get(i).getS()) {
                end = meetings.get(i).getT();
                cnt++;
            }
		}
		System.out.println(cnt);
		sc.close();
	}
}
