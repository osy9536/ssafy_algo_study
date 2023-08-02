package algorithm.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3192 {
    static int[][] arr = new int[3][3];
    static int maxsum = 0, l1,l2;
    public static int findsum() { //sum값 찾기
        int sum,maximum=-1;
        for(int i=0;i<3;i++) { // 가로,세로 sum 최대
            sum=0;
            for(int j=0;j<3;j++) { // 가로
                sum+=arr[i][j];
            }
            if(sum>maximum)
                maximum=sum;
            sum=0;
            for(int j=0;j<3;j++) { // 세로
                sum+=arr[j][i];
            }
            if(sum>maximum)
                maximum=sum;
            sum=0;
            for(int j=0;j<3;j++) { // 대각선 sum l1
                sum+=arr[j][j];
            }
            l1=sum;
            if(sum>maximum)
                maximum=sum;
            sum=0;
            for(int j=0;j<3;j++) { // 대각선 sum l2
                sum+=arr[2-j][j];
            }
            l2=sum;
            if(sum>maximum)
                maximum=sum;
        }
        return maximum;
    }
    public static void find(int x, int y) { //찾아내는 함수
        int twosum=0,cnt=0;
        boolean cant=false;
        for(int i=0;i<3;i++) {  //세로
            if(arr[x][i]!=0)
                twosum+=arr[x][i];
            else
                cnt++;
            if(i==2 && cnt>=2) //두개빈칸이면
                twosum=0;
            else if(i==2 && cnt==1) { //한개빈칸이면
                arr[x][y]=maxsum-twosum;
                return;
            }
        }
        twosum=0; cnt=0;
        for(int i=0;i<3;i++) {  //세로
            if(arr[i][y]!=0)
                twosum+=arr[i][y];
            else
                cnt++;
            if(i==2 && cnt>=2) { //두개빈칸이면
                twosum=0;
                cant=true;
            }
            else if(i==2 && cnt==1) { //한개빈칸이면
                arr[x][y]=maxsum-twosum;
                return;
            }
        }
        if(cant) //못찾았을때
            arr[x][y]=((maxsum-l1)>(maxsum-l2)?(maxsum-l2):(maxsum-l1));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i =0 ; i<3;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }	//입력끝
        if(arr[1][1]==0) { //예외이면
            if(arr[0][0]==0 && arr[2][2]==0 || arr[2][0]==0 && arr[0][2]==0) {
                arr[1][1]=(arr[0][1]+arr[2][1])/2;
            }
        }
        maxsum=findsum(); //총 sum 나옴
        //입력 끝
        for(int i =0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(arr[i][j]==0) { //빈칸일때
                    find(i,j);
                }
            }
        }
        for(int i =0 ; i<3;i++) {
            for(int j=0;j<3;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
