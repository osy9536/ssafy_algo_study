package ssafy_algo_study;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[] check= new int[4];
    static int answer =0 ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        String str = br.readLine();
             
        int[] alpha= new int[4];  //ACGT
        StringTokenizer sin = new StringTokenizer(br.readLine()); 
        for(int i = 0 ; i < 4 ; i++) {
            alpha[i]=Integer.parseInt(sin.nextToken());
        }
        for(int i = 0 ; i < m ; i ++) { //0~m 까지 출현숫자 check 기입
            if(str.charAt(i)=='A') {
                check[0]+=1;
            }
            else if(str.charAt(i)=='C') {
                check[1]+=1;
            }
            else if(str.charAt(i)=='G') {
                check[2]+=1;
            }
            else if(str.charAt(i)=='T') {
                check[3]+=1;
            }
        }
        boolean ck = true;	//ck 로 출현 숫자 비교
        for(int j = 0 ; j < 4 ; j++) {
            if(alpha[j]>check[j])
                ck=false;
        }
        if(ck) answer++; // 첫경우 체크
        int t=0;
        while((m+t)<n) {
            ck = true;
            if(str.charAt(t)=='A') {
                check[0]-=1;
            }
            else if(str.charAt(t)=='C') {
                check[1]-=1;
            }
            else if(str.charAt(t)=='G') {
                check[2]-=1;
            }
            else if(str.charAt(t)=='T') {
                check[3]-=1;
            }
            if(str.charAt(t+m)=='A') {
                check[0]+=1;
            }
            else if(str.charAt(t+m)=='C') {
                check[1]+=1;
            }
            else if(str.charAt(t+m)=='G') {
                check[2]+=1;
            }
            else if(str.charAt(t+m)=='T') {
                check[3]+=1;
            }
            for(int j = 0 ; j < 4 ; j++) {
                if(alpha[j]>check[j])
                    ck=false;
            }
            if(ck) answer++;
            t++;
        }
        System.out.println(answer);
    }
}


