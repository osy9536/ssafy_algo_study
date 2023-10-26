package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;


/*      괄호제거    */

public class b2800 {

    static ArrayList<Character> formula = new ArrayList<>();
    static ArrayList<int[]> bracket = new ArrayList<>();
    static boolean [] isVisited;
    static String s;
    static TreeSet<String> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 각 원소는 [0]에 '('의 index, [1]에 ')'의 index를 저장


        s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            formula.add(s.charAt(i));
            // '(' 만나면 괄호만 저장하는 리스트의 크기 늘리기
            if(s.charAt(i) == '(') {
                bracket.add(new int[] {i,0});
            }

            // ')' 만나면 제일 최근 (의 인덱스 중 페어 못 찾은 녀석을 찾아서 그 녀석의 페어로 넣어주기
            else if(s.charAt(i) == ')') {
                for (int j = bracket.size()-1; j >= 0; j--) {
                    if(bracket.get(j)[1] == 0) {
                        bracket.get(j)[1] = i;
                        break;
                    }
                }
            }
        }
        isVisited = new boolean[bracket.size()];

//    	for (int [] temp : bracket) {
//			System.out.println("괄호 페어 (의 위치: "+ temp[0] + " )의 위치: "+ temp[1]);
//		}

        Combination(0);
        for (String string : set) {
            System.out.println(string);
        }

    }

    // 페어 삭제 조합
    public static void Combination(int deepth) {

        if(deepth == bracket.size()) {
            StringBuilder sb = new StringBuilder().append(s);
            int vaildcnt = 0;
            for (int i = 0; i < isVisited.length; i++) {
                if(isVisited[i]) {
                    sb.replace(bracket.get(i)[0], bracket.get(i)[0]+1, " ");
                    sb.replace(bracket.get(i)[1], bracket.get(i)[1]+1, " ");
                }
                if(!isVisited[i]) {
                    vaildcnt++;
                }
            }

            if (vaildcnt == isVisited.length) {
                return;
            }

            for (int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i) == ' ') {
                    sb.replace(i, i+1, "");
                    i--;
                }
            }

            set.add(String.valueOf(sb));
            return;

        }

        if(!isVisited[deepth]) {
            isVisited[deepth] = true;
            Combination(deepth+1);
            isVisited[deepth] = false;
            Combination(deepth+1);
        }


    }

}


