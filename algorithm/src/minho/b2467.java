import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2467 {
    public static int[] arr;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        //입력 끝
        //이진탐색 시작
        int ans1=0,ans2=0,i=0,j=arr.length-1;
        int temp=Integer.MAX_VALUE;
        while ( i < j ){
            int sum =arr[i]+arr[j];
            if(Math.abs(temp) > Math.abs(sum)){
                ans1 = arr[i];
                ans2 = arr[j];
                temp =sum;
            }
            if(sum > 0) j--;
            else i++;
        }
        System.out.println(ans1+" "+ans2);
    }
}
