package algorithm.src.soomin;
import java.util.*;
import java.io.*;
public class b26069 {

    /*
     * 붙임성 좋은 총총이
     * [26069번] 실버 4
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 춤추는 사람들 명단
        HashMap<String, Integer> dancingMember = new HashMap<>();
        // 일단 춤추는 사람으로 총총이 넣기
        dancingMember.put("ChongChong", 1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String left = st.nextToken();
            String right = st.nextToken();

            // 왼쪽 오른쪽 사람 중 한명이 춤추는 사람 명단에 있고, 나머지 한명은 아닌 경우에, 해당 한명을 HashMap에 추가
            if((dancingMember.get(left) == null && dancingMember.get(right) != null)){
                dancingMember.put(left, 1);
            }
            else if((dancingMember.get(left) !=null && dancingMember.get(right) == null)){
                dancingMember.put(right,1);
            }
        }

        // dancingMember 명부에 써진 사람들의 수가 바로 무지개 댄스를 추는 사람들의 수이다.
        System.out.println(dancingMember.size());

    }
}
