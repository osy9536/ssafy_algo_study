import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[][] = new int[N][2];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken()); //시작시간
            A[i][1] = Integer.parseInt(st.nextToken()); //종료시간
        }
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //종료시간이 같을 경우 시작시간이 빠른 순으로 정렬
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                //양수값이 나온다면 반대로 정렬
                //음수값이 나온다면 그대로 정렬
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prevEndTime = 0;

        for(int i = 0; i < N; i++){
            //직전의 종료시간이 다음 회의 시작시간보다 전이라면 갱신
            if(prevEndTime <= A[i][0]){
                prevEndTime = A[i][1];
                count++;
            }
        }
        System.out.println(count);

    }
}
