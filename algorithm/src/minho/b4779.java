package algorithm.src.minho;

import java.io.*;

public class b4779 {
    static char[] l;
    public static void sol(int a,int b) {
        if(b<3)
            return;
        sol(a,b/3);
        for(int i=a+b/3;i<a+(b/3)*2;i++) l[i]=' ';
        sol(a+b/3*2,b/3);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n;

        while ((n=br.readLine())!=null) {
            int m=Integer.parseInt(n); //입력값 정수변환
            int n3 = (int)Math.pow(3, m); //제곱값
            //제곱구하기
            l = new char[n3];
            for(int i=0;i<n3;i++) l[i]='-'; //채워넣기

            sol(0,n3); //입력값집어넣기
            for(int i=0;i<n3;i++)
                bw.write(l[i]);
            bw.write("\n");
            bw.flush();
        }
    }
}