package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class b1927 {
	public static int binarysearch(List<Integer> nums, int x) {
		int start = 0;
		int end = nums.size()-1;
		
		if (nums.size() == 0) return -1;
		else {
			int idx = 0;
			for (int i = 0; i < nums.size(); i++) {
				int pivot = (start + end) / 2;
				if (nums.get(pivot) == x) {
					idx = pivot;
					break;
				} else if (nums.get(pivot) > x) {
					if (pivot == 0) break;
					else if(end <= start) {
						idx = start;
						break;
					}
					end = pivot -1;
				} else if (nums.get(pivot) < x) {
					if (pivot == nums.size()-1) {
						idx = -1;
						break;
					} else if (end <= start) {
						idx = end+1;
						break;
					}
					start = pivot +1;
				}
			}
			
			return idx;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		List<Integer> nums = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(br.readLine());
			if (now == 0) {
				if (nums.size() == 0) {
					bw.write(0+"\n");
				} else {
					bw.write(nums.get(0)+"\n");
					nums.remove(0);
				}
			} else {
				int nidx = binarysearch(nums, now);
				if (nidx == -1) {
					nums.add(now);
				} else {
					nums.add(nidx, now);
				}
				
			}
		}
		bw.flush();
		bw.close();
	}
}
