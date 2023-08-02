package algorithm.chaesong;

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
            A[i][0] = Integer.parseInt(st.nextToken()); //���۽ð�
            A[i][1] = Integer.parseInt(st.nextToken()); //����ð�
        }
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //����ð��� ���� ��� ���۽ð��� ���� ������ ����
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                //������� ���´ٸ� �ݴ�� ����
                //�������� ���´ٸ� �״�� ����
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prevEndTime = 0;

        for(int i = 0; i < N; i++){
            //������ ����ð��� ���� ȸ�� ���۽ð����� ���̶�� ����
            if(prevEndTime <= A[i][0]){
                prevEndTime = A[i][1];
                count++;
            }
        }
        System.out.println(count);

    }
}
