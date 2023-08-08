package algorithm.src.ohseyoung;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
public class s1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            boolean check = false;
            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i<n; i++) {
                String[] s= br.readLine().split(" ");
                char c = s[1].charAt(0);
                if(s.length==4) {
                    if(c!='*'&&c!='/'&&c!='+'&&c!='-') {
                        check = true;
                        continue;
                    }
                }
                if(s.length==2) {
                    if(c=='*'||c=='/'||c=='+'||c=='-') {
                        check = true;
                        continue;
                    }
                }
            }
            if(check) {
                System.out.println("#"+tc+" "+0);
            }else {
                System.out.println("#"+tc+" "+1);
            }
        }
    }
}
