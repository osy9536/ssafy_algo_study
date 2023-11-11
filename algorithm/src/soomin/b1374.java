package algorithm.src.soomin;
import java.util.*;
import java.io.*;

public class b1374{

    /*
     *  B1374 강의실
     *  문제 풀이
     *  list에 강의를 받아서 시작 순으로 정렬
     *  우선순위 큐를 만들고, 큐의 우선순위는 강의 끝시간이 빠른 순이다.
     *  1.   처음 큐가 비었을 때는 list에서 강의 시작이 제일 빠른 강의를 집어넣는다.
     *  2.   큐에 뭔가 차있을 때는 큐의 맨 처음 값(끝시간이 제일 빠른 값)과 list의 첫 값: 안 쓴 강의 중 시작 시간이 제일 빠른 값을 비교한다.
     *       (2-1) 만약 큐의 앞 대가리의 끝시간 보다, 현재 조회 중인 list의 시작 시간이 늦을 경우, que에 있는 것을 꺼내서 버린다.
     *             이를 list의 현재 조회 중인 강의의 시작시간보다 큐안에 든 강의의 종료시간이 더 늦을 경우까지 반복한다.
     *             (이는 list의 현재 조회 중인 강의의 시작 시간 만큼 시간이 흘러서 그 이전 강의는 전부 끝내고 강의실을 비웠음을 의미한다.)
     *       (2-2) 만약 큐의 앞 대가리 끝시간이 현재 조회중인 list의 강의의 시작시간보다 늦을 경우, 해당 조회 중인 list값을 큐에 넣는다.
     *             (이는 현재 사용 중인 강의실에는 들어갈 수 없으므로, 안 쓰는 빈 강의실을 쓰는 것을 의미한다.)
     * 3. 이렇게 list loop를 도는데, 큐의 사이즈가 제일 클 때를 출력한다. -> 이는 동시에 진행 중인 강의가 제일 많을 때를 의미한다.
     *
     * */

    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        // 강의를 시작 시점으로 정렬, list에서 현재 조회 중인 강의의 시작시간이 현 시점이다.
        ArrayList<Lecture> list = new ArrayList<>();

        // 해당 큐의 사이즈는 현재 진행 중인 강의의 개수
        PriorityQueue<Integer> endTimeLecture = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        // 입력 값 받기
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int No = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Lecture(No, start, end));
        }

        // 시작시간으로 정렬
        list.sort(Comparator.comparingInt(o -> o.start));
        int max = 0;
        for (int i = 0; i < N; i++) {
            // 현재 강의 중인 강의가 존재하고, 해당 강의의 종료 시간이 지금 시작할 강의의 시작시간보다 빠르거나 같다면,
            while(!endTimeLecture.isEmpty() && (endTimeLecture.peek() <= list.get(i).start)){
                // 현재 조회 중인 강의의 시작 시간이 현 시점을 의미하므로, 해당 강의들은 현 시점에서 다 끝난 강의들이다.
                // 현 강의 시작 시점에서 이미 끝난 강의들은 모조리 강의실을 비웠을 것이므로, 큐에서 비운다.
                endTimeLecture.poll();
            }
            // 강의실이 아예 비었거나, 현재 시작해야할 강의보다 종료 시간이 뒤인 강의들만 큐에 남아있다면, 새로운 강의실을 파서 강의를 진행한다.
            endTimeLecture.add(list.get(i).end);
            max = Math.max(max, endTimeLecture.size());
        }

        System.out.println(max);


    }
}

class Lecture{
    int No;
    int start;
    int end;

    public Lecture(int no, int start, int end) {
        No = no;
        this.start = start;
        this.end = end;
    }
}