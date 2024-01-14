package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2110 {
    public static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int low = 1;
        int hi =arr[N-1]-arr[0]+1;

        while(low<hi){
            int mid = (hi+low)/2;
            if(canInstall(mid)<C){
                hi=mid;
            }
            else {
                low = mid + 1;
            }
        }
        System.out.println(low-1);
    }
    public static int canInstall(int distance) {
        int count = 1;
        int lastLocate = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int locate = arr[i];
            if(locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
}