import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class s5202 {
	static Truck[] trucks;
	static Stack<Truck> s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			s = new Stack<>();
			int N = sc.nextInt();
			trucks = new Truck[N];
			for(int i = 0; i < N; i++) {
				trucks[i] = new Truck(sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(trucks, new Comparator<Truck>() {

				@Override
				public int compare(Truck o1, Truck o2) {
					if(o1.s == o2.s) {
						return o1.e-o2.e;
					}
					return o1.s-o2.s;
				}
				
			});
			int prevEndTime = 0;
			for(int i = 0; i < N; i++) {
				if(prevEndTime <= trucks[i].s) {
					prevEndTime = trucks[i].e;
					s.add(trucks[i]);
				}else {
					if(trucks[i].e <= prevEndTime && s.peek().s <= trucks[i].s) {
						s.pop();
						prevEndTime = trucks[i].e;
						s.add(trucks[i]);
					}
				}
			}
			System.out.println("#"+t+" "+s.size());
		}
	}
	static class Truck{
		int s, e; //s는 시작시간, e는 종료시간
		public Truck(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
}
