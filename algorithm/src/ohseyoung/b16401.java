package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 과자 나눠주기
// silver 2
public class b16401 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int jo = Integer.parseInt(st.nextToken());
		int sna = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < sna; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		int left = 1;
		int right = list.get(list.size() - 1);
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			for (int i = 0; i < list.size(); i++) {
				cnt += list.get(i) / mid;
			}
			if (cnt >= jo) {
				left = mid + 1;
			} else
				right = mid - 1;
		}
		System.out.println(right);
	}
}
