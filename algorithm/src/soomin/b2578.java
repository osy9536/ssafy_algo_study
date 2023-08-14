package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b2578 {
    // 2차원 배열을 클래스로 표현
    static Row [] arr = {new Row(), new Row(), new Row(), new Row(), new Row()};

    static boolean [][] flag = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 철수가 써내려간 빙고 값 받기
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i].list.add(Integer.parseInt(st.nextToken()));
            }
        }

        // 사회자의 값 부르기
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int temp = Integer.parseInt(st.nextToken());

                // k값이 수직, temp의 index가 수평 값
                for (int k = 0; k < 5; k++) {
                    if(arr[k].list.contains(temp)){
                        flag[k][arr[k].list.indexOf(temp)] = true;
                    }
                }
                // 유효성 검사
//                System.out.println(i*5 + j +1);
                boolean b = vaild();

                if(b) {
                    System.out.println(i*5 + j +1 );
                    return;
                }


//                System.out.println(i*5+j);
//                for (boolean[] c :
//                        flag) {
//                    System.out.println(Arrays.toString(c));
//                }
//                System.out.println();

            }
        }

        for (Row r :
                arr) {
            System.out.println(r.list);
        }
    }

    public static  boolean vaild (){
        int garo_count = 0;
        int sero_count = 0;
        int LeftD = 0;
        int rightD =0;
        loopout:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(!flag[i][j]) {
                    continue loopout;
                }
            }
            garo_count++;
        }


        loopout:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(!flag[j][i]) {
                    continue loopout;
                }
            }
            sero_count++;
        }


        if(flag[0][0] && flag[1][1] && flag[2][2] && flag[3][3] && flag[4][4]){
            LeftD++;
        }

        if (flag[0][4] && flag[1][3] && flag[2][2] && flag[3][1] && flag[4][0]) {
            rightD++;
        }

        int count = sero_count+garo_count+LeftD+rightD;

//        System.out.println("최종"+ count );
//        System.out.println();

        if (count >=3){
            return  true;
        }else {
            return  false;
        }

    }
}

class Row {
    ArrayList<Integer> list = new ArrayList<>();

}