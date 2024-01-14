package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b11053 {

    // dp의 길이가 최장 증가 부분 수열의 길이이다.
    // 배열을 순회하면서 값을 받는다. 현재 내가 보고 있는 배열의 원소가 dp 배열의 제일 끝단의 원소보다 클 경우, dp 배열의 맨 끝에 삽입한다.
    // 아닐 경우, dp 배열의 원래 값들 중 이분탐색으로 자기보다 큰 값이 오른쪽, 작은 값이 왼쪽에 있는 배열칸에 값을 할당한다.
    // 끝날 때까지 반복

    static ArrayList<Integer> dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        dp = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp.add(arr[0]);

        for (int i = 1; i < N; i++) {
            if(arr[i] > dp.get(dp.size()-1)){
                dp.add(arr[i]);
            }else{
                dp.set(binarySearch(arr[i]), arr[i]);
            }
        }

        System.out.println(dp.size());


    }

    private static int binarySearch(int target) {
        int start = 0;
        int end = dp.size() - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (dp.get(mid) >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}