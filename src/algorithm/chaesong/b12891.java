package algorithm.chaesong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b12891 {
    //main 함수 밖에서도 써야하기 떄문에 static선언
    static int checkACGT[];
    static int myACGT[];
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        //주어진 문자열
        char checkArr[] = br.readLine().toCharArray();

        //만족해야하는 ACTG 개수

        //위에 만들어 줬더라도 밑에서 초기화 해야함!! 사이즈가 얼만지
        checkACGT = new int[4];
        myACGT = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            checkACGT[i] = Integer.parseInt(st.nextToken());
            if(checkACGT[i] == 0) cnt++;
        }//입력값 끝

        //정답
        int ans = 0;

        //처음 문자 배열엔 ACGT가 몇 개 있는지?
        for(int i = 0; i < P; i++) {
            add(checkArr[i]);
        }
        if(cnt == 4) ans++;

        //슬라이딩 윈도우 시작
        for(int j = P; j < S; j++) {
            add(checkArr[j]);
            int i = j - P;
            remove(checkArr[i]);
            if(cnt == 4) {
            ans++;
            }
        }
        System.out.println(ans);
        br.close();
    }

    //처음 들어오는 char을 내 ACGT에 반영해주는 함수
    //main함수 안에서 쓰려면 static, 메모리에 올라와 있어야 함
    public static void add(char c) {
        switch(c) {
            case 'A':
                myACGT[0]++;
                if(myACGT[0] == checkACGT[0]) cnt++;
                break;
            case 'C':
                myACGT[1]++;
                if(myACGT[1] == checkACGT[1]) cnt++;
                break;
            case 'G':
                myACGT[2]++;
                if(myACGT[2] == checkACGT[2]) cnt++;
                break;
            case 'T':
                myACGT[3]++;
                if(myACGT[3] == checkACGT[3]) cnt++;
                break;
        }
    }

    //빠지게 되는 char을 내 ACGT에 반영해주는 함수
    //나는 add를 먼저하고 remove를 할거임
    //모든 작업이 끝나고 ACGT의 개수가 조건을 만족하지 않는다면 cnt를 뺀다
    public static void remove(char c) {
        switch(c) {
            case 'A':
                if(myACGT[0] == checkACGT[0]) cnt--;
                myACGT[0]--;
                break;
            case 'C':
                if(myACGT[1] == checkACGT[1]) cnt--;
                myACGT[1]--;
                break;
            case 'G':
                if(myACGT[2] == checkACGT[2]) cnt--;
                myACGT[2]--;
                break;
            case 'T':
                if(myACGT[3] == checkACGT[3]) cnt--;
                myACGT[3]--;
                break;
        }
    }
}