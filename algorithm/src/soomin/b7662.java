package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.*;

public class b7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        for (int T = 0; T < test_case; T++) {
            int N = Integer.parseInt(br.readLine());

            // 처음 테스트 케이스에서 쓰일 연산의 횟수
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char order = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if(order == 'I'){
                    // 만약 그 키가 이미 존재한다면, 나온 횟수를 +1
                    if(treeMap.containsKey(num)){
                        treeMap.put(num, treeMap.get(num)+1);
                    }else{
                        // 만약 해당 숫자로 key가 존재하지 않는다면, 신설
                        treeMap.put(num,1);
                    }
                }

                if(order == 'D'){
                    if(treeMap.isEmpty()){
                        continue;
                    }
                    if(num == 1){
                        int max = treeMap.lastKey();

                        treeMap.replace(max, treeMap.get(max)-1);

                        if(treeMap.get(max) == 0){
                            treeMap.remove(max);
                        }

                    }
                    if(num == -1){
                        int min = treeMap.firstKey();

                        treeMap.replace(min, treeMap.get(min)-1);

                        if(treeMap.get(min) == 0){
                            treeMap.remove(min);
                        }
                    }
                }
            }
            if(treeMap.isEmpty()){
                sb.append("EMPTY").append("\n");
            }
            else {
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
            }
            treeMap.clear();
        }
        System.out.println(sb);
    }
}