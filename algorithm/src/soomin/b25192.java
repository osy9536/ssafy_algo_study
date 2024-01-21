package algorithm.src.soomin;
import java.util.*;
import java.io.*;
public class b25192 {

    /*
     * 인사성 밝은 곰곰이
     * [25192번] 실버 4
     * 제발 꾸준히 풀자... 전수민!!!!!!!!!!!!
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int SUM = 0;

        HashMap<String, Integer> name = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            // 새로운 사람이 또 입장하면 명부 초기화
            if(s.equals("ENTER")){
                name.clear();
            }
            else {
                // 채팅 처음 쓰는 사람이면 무조건 곰곰티콘을 쓴다!  따라서 카운트 업
                // + 해당 사람이 다음에 또 채팅쓰는 것은 카운트에 안 넣기 위해 명부에다가 쓴다. 명부 == name이란 이름의 HashMap
                if(name.get(s) == null) {
                    name.put(s, 1);
                    SUM++;
                }
            }
        }

        System.out.println(SUM);



    }
}
