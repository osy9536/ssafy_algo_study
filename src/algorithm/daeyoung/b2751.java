package algorithm.daeyoung;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 백준 2751
 * 수 정렬하기2
 * 실버 5
 * https://www.acmicpc.net/problem/2751
 */
public class b2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(nums);
        for(int num : nums)
            sb.append(num ).append('\n');

        System.out.println(sb);
    }
}

