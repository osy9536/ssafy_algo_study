package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeMap;

public class b11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // <절댓값, 클래스(-가 나온 횟수, +가 나온 횟수)>
        TreeMap<Long, Abs> map = new TreeMap<>(Collections.reverseOrder());


        for(int test_case = 0; test_case< N; test_case++) {

            if(!map.isEmpty()) {
                if(map.get(map.lastKey()).plus == 0 && map.get(map.lastKey()).minus == 0) {
                    map.pollLastEntry();
                }
            }

            long current = Long.parseLong(br.readLine());



            // 만약 입력이 0이 아니다.
            if(current !=0) {

                // 그런데 해당 입력이 아직 map에 포함되지 않았다.
                if(!(map.containsKey(Math.abs(current)))) {
                    // 해당 수가 음수 일 경우, 해당 수의 절댓값 key의 minus 나온 횟수를 ++
                    if(current <0) {
                        map.put((Math.abs(current)), new Abs(0,1));
                    }// 해당 수가 양수일 경우, 해당 수의 절댓값 key의  Plus가 나온 횟수를 ++
                    else if (current >=0) {
                        map.put(current, new Abs(1,0));
                    }
                }
                // 이미 해당 입력이 있다면
                else {
                    // 위와 과정은 똑같다.
                    if(current < 0) {

                        map.get(Math.abs(current)).minus +=1;
                    }else {
                        map.get(current).plus +=1;
                    }

                }
                // 입력이 0인 경우
            }else {
                // 입력이 0인데 비어있는 경우 0 출력 후 다음 것
                if(map.isEmpty()) {
                    System.out.println(0);
                    continue;

                    // map 안이 비지 않은 경우
                }else {

                    // 최소값의 minus 나온 횟수가 0이 아닌 경우
                    if(map.get(map.lastKey()).minus != 0) {
                        System.out.println(-(map.lastKey()));
                        map.get(map.lastKey()).minus--;
                    }
                    // 최소값의 minus 나온 횟수는 0이고, Plus 나온 횟수가 남았을 경우
                    else {
                        System.out.println(map.lastKey());
                        map.get(map.lastKey()).plus --;

                        // 둘 다 0이면 그 key는 map에서 삭제
                    }
                }
            }

//    		for(Long key : map.keySet()) {
//    			System.out.println("[Map의 key : " + key + "\t key의 -값: "
//    								+map.get(key).minus +"\t key의 +값: "
//    								+ map.get(key).plus+"]");
//    		}

        }
    }
}
class Abs {
    int plus;
    int minus;

    public Abs(int plus, int minus) {
        this.plus = plus;
        this.minus = minus;
    }
}