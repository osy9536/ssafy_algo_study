package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class b1107 {

    /*
     *   초기 채널 100번
     *   원하는 채널 번호를 알려주는데, 그 채널로 가는데 리모컨 버튼을 몇 번 눌러야 하는지 세어라.
     *   단, 고장난 버튼이 있으며 해당  버튼은 누를 수 없다.
     */

    /*  풀이방식  */
    // 1. 일단 숫자 버튼으로 갈 수 있는 최대한 가까운 값으로 간다.
    // (1) 타겟번호의 숫자가 금지되지 않은 숫자라면 해당 숫자로 해당 자릿수는 채워넣는다. -> 만약 다 채워지면, 그대로 출력
    // (2) 한 자리라도 못 채우면, 그 자리를 채우는 중복순열을 실시한다.
    //  -> 해당 레벨에서만 갱신되는 절대값 차 변수를 두고, 그 변수보다 타겟넘버 - 현재 채워넣을 수의 차의 절대값이 클 경우
    // 순열을 행하지 않는다.
    // 2. 그 값에서 목표값 까지의 차이의 절댓값을 버튼 누른 횟수에 더한다. (초기 버튼 누른 횟수: 숫자 버튼 누른 횟수)
    // 3. 100번에서 +,-으로 그곳에 간 횟수와 비교하여 최소값을 출력한다.


    static int target;

    static char [] targetArr;
    static ArrayList<Integer> remoteNum = new ArrayList<>();
    static  boolean [] isVisited = new boolean[10];
    static char [] input;

    static int subMin = Integer.MAX_VALUE;
    static int buttonValue;

    public static void main(String[] args) throws IOException {

        remoteNum.add(0);
        remoteNum.add(1);
        remoteNum.add(2);
        remoteNum.add(3);
        remoteNum.add(4);
        remoteNum.add(5);
        remoteNum.add(6);
        remoteNum.add(7);
        remoteNum.add(8);
        remoteNum.add(9);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 목표 채널 번호 저장
        target = Integer.parseInt(br.readLine());
        targetArr = String.valueOf(target).toCharArray();
        input = new char[targetArr.length+1];

        int N = Integer.parseInt(br.readLine());


        // 리모컨에서 고장난 버튼 제외
        if(N>0){
            StringTokenizer st =new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(st.nextToken());
                remoteNum.remove(Integer.valueOf(value));
                isVisited[value] = true;
            }
        }

        int cnt = 0;
        // 현 리모컨으로 눌렀을 때 해당 번호로 갈 수 있는지 체크
        for (int i = 0; i < targetArr.length; i++) {
            if(remoteNum.contains(targetArr[i] - '0')){
                cnt ++;
            }
        }
        if(cnt == targetArr.length){
            System.out.println(Math.min(Math.abs(target-100), cnt));
            return;
        }

        if(remoteNum.isEmpty()){
            System.out.println(Math.abs(target-100));
            return;
        }



        Permutation2(0);
        Permutation(0);
        if(targetArr.length-1 >0){
            Permutation3(0);
        }

        int num = String.valueOf(buttonValue).length();



        System.out.println(Math.min(Math.abs(target-100), Math.abs(target-buttonValue) + num));

    }

    public static void Permutation(int deepth) {

        if(deepth == targetArr.length){
            int value = 0;
            for (int i = 0; i < input.length-1; i++) {
                value += (int)(input[i] - '0')*(Math.pow(10,input.length-(i+2)));
            }
            if(Math.abs(target-value) <= subMin){
                subMin = Math.abs(target-value);
                buttonValue = value;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(isVisited[i]) continue;

            input[deepth] = (char)(i +'0');
            Permutation(deepth+1);

        }
    }

    public static void Permutation2(int deepth) {

        if(deepth == targetArr.length+1){
            int value = 0;
            for (int i = 0; i < input.length; i++) {
                value += (int)(input[i] - '0')*(Math.pow(10,input.length-(i+1)));
            }
            if(Math.abs(target-value) <= subMin){
                subMin = Math.abs(target-value);
                buttonValue = value;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(isVisited[i]) continue;

            input[deepth] = (char)(i +'0');
            Permutation2(deepth+1);

        }
    }

    public static void Permutation3(int deepth) {

        if(deepth == targetArr.length-1){
            int value = 0;
            for (int i = 0; i < input.length-2; i++) {
                value += (int)(input[i] - '0')*(Math.pow(10,input.length-(i+3)));
            }
            if(Math.abs(target-value) <= subMin){
                subMin = Math.abs(target-value);
                buttonValue = value;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(isVisited[i]) continue;

            input[deepth] = (char)(i +'0');
            Permutation3(deepth+1);

        }
    }

}
