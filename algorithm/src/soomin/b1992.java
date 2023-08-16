package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b1992 {
    static ArrayList<String> list = new ArrayList<>();
    static StringBuilder ans = new StringBuilder("(");
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());




        for(int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        if(N == 1) {
            System.out.println(list.get(0));
        }else {
            QuadTree(0,0,N, 0);
            ans.append(")");

            if(String.valueOf(ans).equals("(1111)")) {
                System.out.println(1);
                return;
            }else if(String.valueOf(ans).equals("(0000)")) {
                System.out.println(0);
            }

            System.out.println(String.valueOf(ans));
        }

    }

    public static void QuadTree(int x, int y, int size, int deepth) {
        // 기저 조건


        int [] idx = {0,0,size/2,size/2};
        int [] idy = {0,size/2,0,size/2};
        int [] shifting = {N-(y+size/2), N-(y+size/2*2),N-(y+size/2), N-(y+size/2*2)};

//    	if(deepth == ((int)Math.log(N))-1) {
//    		int i = 0;
//    		while(i<4) {
//    			int vaild = isVaild(x+idx[i], y+idy[i], shifting[i], size);
//    			if(vaild == 1) {
//    				ans.append(1);
//    			}
//    		}
//    		i++;
//    	};

        // 유효성 검사 및 유도 부분
        int i = 0;
        while(i<4) {
            // 1사분면
            // 2사분면
            // 3사분면
            // 4사분면
            int vaild = isVaild(x+idx[i], y+idy[i], shifting[i], size);
            if(vaild == 1) {
                ans.append(1);
            }

            else if(vaild == 0) {
                ans.append(0);
            }

            else {
                ans.append("(");
                QuadTree(x+idx[i],y+idy[i], size/2, deepth+1);
                ans.append(")");
            }
            i++;
        }
        return;
    }

    public static int isVaild(int idx, int idy, int shifting, int size) {

        int cnt = 0;
        long vaild = ((int)Math.pow(2, size/2)-1);

        for(int i = idx; i < idx+size/2; i ++) {
            if((Long.parseLong(list.get(i).substring(idy, idy+size/2), 2) & vaild) == (vaild)) {
                cnt++;
            }
        }
        if(cnt == size/2) {
            return 1;
        }else {
            cnt = 0;
            for(int i = idx; i < idx+size/2; i ++) {
                if((Long.parseLong(list.get(i).substring(idy, idy+size/2), 2) & vaild) == 0) {
                    cnt++;
                }
            }
            if(cnt == size/2) {
                return 0;
            }else {
                return -1;
            }
        }
    }
}
