package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b2458 {

    /*	문제 설명
     *	반 친구들 사이에서 키를 비교함.
     *	키를 1대1 비교하는데, 1:N으로 전부 다 한 것 아님. 예를 들어 A,B,C,D가 있으면 A,B 키 비교, BC비교 CD비교했으면 A는 C나 B와 비교를 안한것임
     *	따라서 누구는 키 비교하는 거 보고 자기가 몇 번째 순서인지 아는데, 누구는 모른다.
     * 	자기가 몇 번째 키 순서인지 아는 학생의 수를 구하라
     * */

    /*	문제 풀이	*/
    // 1. 양방향 그래프를 그린다.
    // 2. 모든 정점에서 출발하여 bfs를 돌린다.
    // 3. 정점 비교 횟수 배열을 만들고, bfs를 돌려서 특정 정점에 방문했을 경우, 출발 정점과 비교 정점을 cnt+1씩 올린다.
    //		bfs를 타고 도달할 수 있는 정점은, 인접하지 않아도 서로 간접적으로 비교가 된다는 소리이기 때문이다.
    // 4. 모든 정점에 대한 bfs를 마치고, 정점 A의 방문 횟수가 정점의 갯수와 일치하면, 해당 정점은 자신의 순위를 아는 녀석이다. 이 수를 센다.

    static ArrayList<Integer> [] lists;
    static boolean [] isVisted;
    static int [] EdgeCnt;
    static int studentNum;


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        studentNum = Integer.parseInt(st2.nextToken());
        int compareNum = Integer.parseInt(st2.nextToken());

        lists = new ArrayList [studentNum];
        EdgeCnt = new int[studentNum];

        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<Integer>();
        }

        // 인접 리스트 작성
        for (int i = 0; i < compareNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int destination = Integer.parseInt(st.nextToken())-1;

            lists[start].add(destination);
        }

        // 모든 정점에 대해서 bfs 돌리기
        for (int i = 0; i < studentNum; i++) {
            bfs(i);
        }


        // 배열의 갯수와 같은 Edgecnt 찾기 -> 해당 정점은 직간접적으로 모든 정점과 키 비교가 된 것임
        int ans = 0;
        for (int i = 0; i < studentNum; i++) {
            if(EdgeCnt[i] == studentNum-1) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static void bfs(int start) {

        isVisted = new boolean[studentNum];

        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        aq1.add(start);
        isVisted[start] = true;

        while(!aq1.isEmpty()) {
            int cur = aq1.poll();

            for (int i = 0; i < lists[cur].size(); i++) {

                int nV = lists[cur].get(i);

                if(!isVisted[nV]) {
                    aq1.add(nV);
                    isVisted[nV] = true;
                    EdgeCnt[start] +=1;
                    EdgeCnt[nV] +=1;
                }

            }
        }


//		for (int i = 0; i < 6; i++) {
//			System.out.print(EdgeCnt[i] + " ");
//		}
//		System.out.println();
    }
}