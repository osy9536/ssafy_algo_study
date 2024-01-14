package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*랜선 자르기*/
public class b1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];

        int max = 0;

        for (int i = 0; i < N; i++) {
            int LAN =  Integer.parseInt(br.readLine());
            arr[i] =LAN;
            max = Math.max(max, LAN);
        }


        long bottom = 1;
        long top = max;
        long mid;

        // 원하는 개수보다 많이 잘라도 되지만, 최대한 타겟값에 가까워야함.
        // 상한선이 낮아질수록 더 많이 잘리고, 하한선이 높아질수록 더 적게 잘림.
        // 따라서 딱 맞아떨어지는 값이 없어서 상한선과 하한선이 만나고 교차될 때,
        // 상한선이 밑으로 내려가야함.
        while (bottom<=top){
            int lanCount = 0;
            mid = (bottom+top)/2;

            for (int i = 0; i < N; i++) {
                lanCount += arr[i]/mid;
            }
//            System.out.println(top + "<- top  bottom -> " + bottom);
//            System.out.print("mid 값: "+mid + " ");
//            System.out.println("랜선의 개수:"+lanCount);


            if(lanCount >= M){
                bottom = mid+1;
            }else{
                top = mid-1;
            }

//            System.out.println();
        }

//        System.out.println(top + "<- top  bottom -> " + bottom);


        System.out.println(top);


    }
}
