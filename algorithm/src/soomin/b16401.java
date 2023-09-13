package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b16401 {

    static int M, N;
    static ArrayList<Integer> list = new ArrayList<>();

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        binarySearch(1, list.get(list.size()-1));
    }
    public static void binarySearch(int start, int end) {

        int cnt = 0;
        int mid =(start+end)/2;

        // 빗겨나가면 경우의 수 전부 체크한 것
        if(end < start){
            System.out.println(result);
            return;
        }


        for (int i = 0; i < list.size(); i++) {
            cnt +=  list.get(i)/(mid);
        }


        if(cnt >= M){
            result = mid;
            binarySearch(mid+1, end);
        } else {
            binarySearch(start,mid-1);
        }

    }
}
