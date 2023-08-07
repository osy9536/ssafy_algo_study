package algorithm.src.jisu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class b16953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		Queue<Long> num = new LinkedList<Long>();
		Queue<Long> count = new LinkedList<Long>();
		num.add(a*2);
		num.add(Long.parseLong(a+"1"));
		count.add((long) 1);
		count.add((long)1);
		Set<Long> visit = new HashSet<Long>();
		visit.add(a);
		visit.add(a*2);
		visit.add(Long.parseLong(a+"1"));
		
		while (num.size() != 0) {
			long now = num.poll();
			long cnt = count.poll();
			
			
			if (now == b) {
				System.out.println(cnt+1);
				break;
			} else if (now > b) {
				if (num.size() == 0) System.out.println(-1);
				continue;
			}
			
			long twice = now * 2;
			long plusone = Long.parseLong(now+"1");
			
			if (!visit.contains(twice)) {
				num.add(twice);
				count.add(cnt+1);
				visit.add(twice);
			}
			if (!visit.contains(plusone)) {
				num.add(plusone);
				count.add(cnt+1);
				visit.add(plusone);
			}
			
		}
	}
}
