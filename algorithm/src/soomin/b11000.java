package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b11000 {

    static int N;

    static int maxQsize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Lecture2 [] list = new Lecture2[N];

        // 값 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end= Integer.parseInt(st.nextToken());

            list[i] = new Lecture2(start, end);
        }

        // 시작 순으로 정렬
        Arrays.sort(list, Comparator.comparingInt(o -> o.start));



        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < list.length; i++) {
            Lecture2 now = list[i];

            if(pq.isEmpty()){
                pq.offer(now.end);
            }
            else{
                int Qsize = pq.size();

                for (int j = 0; j < Qsize; j++) {
                    if(now.start >= pq.peek()) pq.poll();
                    else{
                        pq.add(now.end);
                        break;
                    }
                }

                maxQsize = Math.max(maxQsize, pq.size());
            }
        }

        System.out.println(maxQsize);

    }
}

class Lecture2 {
    int start;
    int end;

    public Lecture2 (int start, int end) {
        this.start = start;
        this.end = end;
    }
}
