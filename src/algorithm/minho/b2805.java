package algorithm.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a= Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());
        int[] l = new int[a];
        int min = 0;
        int max = 0;
        st= new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i< a;i++){
            l[i]=Integer.parseInt(st.nextToken());
            if(max<l[i])
                max=l[i];
        }
        while(min < max) {
            int ans = (min+max)/2;
            long sum=0;
            for(int i:l){
                if(i-ans>0)
                    sum+=i-ans;
            }
            if(sum<b)
                max=ans;
            else{ //맞을때
                min=ans+1;
            }
        }
        System.out.println(min-1);
    }
}
