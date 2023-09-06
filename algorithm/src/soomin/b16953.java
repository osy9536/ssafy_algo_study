package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16953 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int cnt = 1;

            if(A==B){
                System.out.println(1);
            }

            while(A != B){
                if(B%2 == 0){
                    B = B/2;
                    cnt++;
                }else if(B%10 == 1){
                    B -=1;
                    B /= 10;
                    cnt++;
                }else{
                    System.out.println(-1);
                    return;
                }

                if(A>B){
                    System.out.println(-1);
                    return;
                }

                if(A==B){
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }

