package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1074 {
    static int N,r,s, size;
    static int cnt = 0;
    static int [] idx = {0,0,1,1};
    static int [] idy = {0,1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        size = N>1? (int)Math.pow(2, N) : 1;

        if(size == 1){
            for (int i = 0; i < 4; i++) {
                int x = idx[i];
                int y = idy[i];
                if(x == r && y == s){
                    System.out.println(i);
                    break;
                }

            }
        }else {

            moveZ(0,0,size);

            System.out.println(--cnt);
        }




    }


    public static int moveZ(int i, int j, int size) {

        // r,s가 4분면 중 어디에 있는지 확인, 해당 분면보다 밑인 것들은 일괄 더하기
        // r,s가 있는 분면은 일괄 더하기


        //기저조건
        if(size ==2) {

            for (int j2 = 0; j2 < 4; j2++) {
                int nx = i + idx[j2];
                int ny = j + idy[j2];
                cnt++;

                if(nx == r && ny == s) {
                    return -1;
                }
            }
            return 0;
        }


        int limit = (size/2)-1;

        // 4분면
        if(r > limit+i && s > limit+j) {
            cnt += (size/2)*(size/2) * 3 ;
            moveZ(i+(size/2), j+(size/2), size/2);
        }
        // 3분면
        else if(r>limit+i && s <= limit+j) {
            cnt += (size/2)*(size/2) * 2 ;
            moveZ(i+(size/2),j,size/2);
        }
        // 2분면
        else if(r <= limit +i && s > limit +j) {
            cnt += (size/2)*(size/2) ;
            moveZ(i, j+(size/2), size/2);

            // 1분면
        }else if(r <=limit +i && s <=limit +j) {
            moveZ(i, j, size/2);
        }

        return 0;


        //유도부분
//		if (moveZ(i,j,size/2) == -1) return -1;
//		if(moveZ(i,j+size,size/2) == -1 ) return -1;
//		if(moveZ(i+size,j,size/2) == -1 ) return -1;
//		if(moveZ(i+size,j+size,size/2) == -1) return -1;
//		return -1;
    }

}
