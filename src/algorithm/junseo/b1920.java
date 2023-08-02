package algorithm.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
이분탐색 첫 번째 수찾기
 */
public class b1920 {
    public static int [] arrA;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        arrA = new int[N];
        st = new StringTokenizer(br.readLine());
        int i;
        for(i = 0; i<N;i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);

        ///////////////////////////////////////////////////////////////////

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int [] arrX = new int[M];
        st = new StringTokenizer(br.readLine());
        for(i = 0; i<M;i++){
            arrX[i] = Integer.parseInt(st.nextToken());
        }

        //////////////////////////////////////////////////////////////////

        for(i = 0; i<M;i++) {
            if(binarySearch(arrX[i])>0) System.out.println(1);
            else                        System.out.println(0);
        }

    }
    public static int binarySearch(int key){
        int lo = 0;
        int hi = arrA.length-1;
        while (lo<=hi){//lo을 올리고,hi을 낮추면서 탐색을 진행하기 때문
            int idx = (lo+hi)/2;

            if      (arrA[idx] == key)    return 1;
            else if (arrA[idx]>key)       hi=idx-1;
            else                          lo = idx+1;
        }
        return 0;
    }
}

