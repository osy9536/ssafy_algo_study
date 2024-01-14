package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 *   가장 긴 증가하는 부분 수열2
 *   배열의 일부분을 쭉 나열했을 때, 가장 긴 증가하는 부분 수열의 길이를 구하여라.
 */

/*  문제 풀이
 *   dp 배열을 생성, dp 배열 첫 원소로 target 배열의 첫 원소값을 저장.
 *   그 후 target 배열을 순회
 *   target 배열의 현재 조회 중인 원소의 값이 dp 배열의 끝값보다 크면, dp 배열의 그 다음 값으로 집어넣기 -> 배열의 크기가 커진다.
 *   만약 dp 배열의 끝값 보다 작으면, dp 배열 이분탐색으로 돌면서, 자기보다 큰 값이 오른쪽, 작은 값이 왼쪽인 위치의 원소를 현재 조회 중인 값으로 갱신
 */

public class b12738 {

    static int N;
    static int [] arr;
    static ArrayList<Integer> dp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        // 값 담기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp.add(arr[0]);

        for (int i = 1; i < N; i++) {
            if(arr[i] > dp.get(dp.size()-1)){
                dp.add(arr[i]);
            }
            else{
                dp.set(binarySearch(arr[i]),arr[i]);
            }
        }

        System.out.println(dp.size());

    }

    // target 값이 dp 내에 갱신 되어야할 index를 반환
    public static int binarySearch(int target){
        //각각 dp의 맨 왼쪽 index, 맨 오른쪽 인덱스
        int left = 0;
        int right = dp.size();
        int mid;
        while (left <= right){
            mid = (left+right)/2;

            // 타겟값보다 중앙값이 크거나 같을 시,
            if(dp.get(mid) >= target) {
                right = mid-1;
            }
            // 타겟값보다 중앙값이 작을 시,
            else{
                left = mid+1;
            }
        }

        return  left;
    }
}
