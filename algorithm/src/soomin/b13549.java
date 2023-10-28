package algorithm.src.soomin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



/* 13549 숨바꼭질 2
 * */

/*  문제 풀이 방법
 *
 * */

public class b13549 {

    //우선순위 큐
    static PriorityQueue<Node2> pq = new PriorityQueue<>();
    // index == 노드 번호, 들고 있는 값: 시작점에서 해당 node까지 가기 위한 비용
    static int [] coordinate = new int[100001];



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N= 시작 노드, K= 도착 노드
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 다익스트라 사용하기 위한, 좌표 배열 초기화
        Arrays.fill(coordinate, Integer.MAX_VALUE);

        if(N==K) {
            System.out.println(0);
            return;
        }else if(N > K) {
            System.out.println(N-K);
            return;
        }else {
            coordinate[N] = 0;
            pq.add(new Node2(N, coordinate[N]));

            while(!pq.isEmpty()){
                // 우선순위 큐는 항상 현재 시작점에서 갈 수 있는 노드 중 비용이 제일 작은 노드를 뱉는다.
                Node2 cur = pq.poll();

                int nextIdx, nextWeight;

                // 한 칸 앞으로 가기.
                nextIdx = cur.index+1;
                nextWeight = cur.weight+1;

                // 현재 이동해서 간 값이 기존에 글로 가는 비용보다 작으면, 최신화 시키고, 우선순위 큐에 집어넣는다.
                if(nextIdx<=100000) {
                    if (coordinate[nextIdx] > nextWeight) {
                        coordinate[nextIdx] = nextWeight;
                        pq.add(new Node2(nextIdx, nextWeight));
                    }
                }

                // 한 칸 뒤로 가기
                nextIdx = cur.index -1;
                nextWeight = cur.weight +1;

                if(nextIdx>=0) {
                    if (coordinate[nextIdx] > nextWeight) {
                        coordinate[nextIdx] = nextWeight;
                        pq.add(new Node2(nextIdx, nextWeight));
                    }
                }

                // 2베 앞으로 가기
                nextIdx = cur.index*2;
                nextWeight = cur.weight;

                if(nextIdx<=100000) {
                    if (coordinate[nextIdx] > nextWeight) {
                        coordinate[nextIdx] = nextWeight;
                        pq.add(new Node2(nextIdx, nextWeight));
                    }
                }

            }
        }
        System.out.println(coordinate[K]);
    }

}

// Node의 번호와 시작점에서 거기까지 가는 거리를 가지고 있는 클래스
class Node2 implements Comparable<Node2> {
    // 노드의 인덱스와 노드까지 가는 거리
    int index;
    int weight;

    Node2(int index, int weight){
        this.index = index;
        this.weight = weight;
    }


    // 비교 기준을 설정, 만약 현재 값이 비교하려는 값보다 크면 뒤로 보낸다.
    @Override
    public int compareTo(Node2 that) {
        if(this.weight > that.weight){
            return 1;
        }else if(this.weight == that.weight){
            return this.index - that.index;
        }else{
            return -1;
        }
    }
}
