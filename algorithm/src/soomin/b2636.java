package algorithm.src.soomin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.BitSet;
import java.util.StringTokenizer;



/* 13549 숨바꼭질 2
 * */

/*  문제 풀이 방법
 *
 * */

public class b2636 {
    // N: 가로, M: 세로
    static int N,M;

    // 치즈:1, 빈공간:0, 그래프의 가장자리 노드: 'x'
    static char [][] graph;
    //치즈 개수 세기
    static int cheeseCnt  = 0;
    static int pastCheeseCnt = 0;
    //치즈 삭제되는 턴 세기 -> 1턴 == 1시간
    static int turnCnt = 0;

    // 검색할 치즈들이 들어있는 덱
    static ArrayDeque<Coordinate9> aq1 = new ArrayDeque<>();
    // 치즈 가장자리 찾는 bfs
    static ArrayDeque<Coordinate9> searchEdgeQ = new ArrayDeque<>();

    // 가장자리 치즈 삭제용 덱
    static ArrayDeque<Coordinate9> deleteCheese = new ArrayDeque<>();
    //사방탐색용 idx, idy
    static int [] idx = new int[]{-1,0,1,0};
    static int [] idy = new int[]{0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N+1][M+1];

        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], 'X');
        }


        // 그래프 값 입력 받기, 가장자리는 -1이 들어가도록 했다.
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {

                graph[i][j] = st.nextToken().charAt(0);

                //1이면 bfs 돌리기 위해 덱에 집어넣는다.
                if(graph[i][j] == '1'){
                    aq1.add(new Coordinate9(i,j));
                    cheeseCnt++;
                }

                // 가장자리 값은 x로 바꾼다.
                if(i == 1 || j == 1 || i == N || j==M){
                    graph[i][j] = 'X';
                }
            }
        }

        findEdge();
        System.out.println(turnCnt);
        System.out.println(pastCheeseCnt);

    }


    public static void findEdge() {

        char [][] copyGraph = new char[N+1][M+1];

        while (!aq1.isEmpty()){
            pastCheeseCnt = cheeseCnt;
            // 한 턴, 한 턴 세기 위해
            int Qsize = aq1.size();
            turnCnt++;
            for (int i = 0; i < Qsize; i++) {
                Coordinate9 cur = aq1.poll();

                // 해당 치즈가 가장자리에 존재하는 치즈인지 확인 -> 해당 치즈 위치에서 bfs 해서 가장자리 'X'만나면 그 치즈는 가장자리
                boolean isEdge = false;
                searchEdgeQ.add(cur);

                // bfs에 쓸 배열 복사
                for (int j = 0; j <= N; j++) {
                    System.arraycopy(graph[j], 0, copyGraph[j], 0,graph[j].length);
                }

                // bfs를 돌려서 해당 노드가 결국에는 그래프의 가장자리에 만나는지 확인 -> 만나면 그 노드는 가장자리
                loopout:
                while(!searchEdgeQ.isEmpty()){
                    Coordinate9 nowCheese = searchEdgeQ.poll();

                    for (int j = 0; j < 4; j++) {
                        int nx = nowCheese.x + idx[j];
                        int ny = nowCheese.y + idy[j];

                        if(nx>=1 && ny>=1 && nx <= N && ny <=M){
                            if(copyGraph[nx][ny] == '0'){
                                // 방문 표시
                                copyGraph[nx][ny] = 'D';
                                searchEdgeQ.add(new Coordinate9(nx,ny));
                            }

                            // 가장자리를 만났다면,
                            if(copyGraph[nx][ny] == 'X'){
                                isEdge = true;
                                searchEdgeQ.clear();
                                break loopout;
                            }
                        }
                    }
                }
                searchEdgeQ.clear();

                // 가장자리의 치즈가 맞다면, 그래프에 해당 좌표의 값을 C로 바꾸기.
                // 바로 지우면 안된다. 그러면 현재 turn에서 다음 치즈 계산시 영향을 미치므로,
                if(isEdge){
                    graph[cur.x][cur.y] = 'C';
                    deleteCheese.add(cur);
                }

                // 가장자리의 치즈가 아니라면, 다시 큐에 넣기
                else{
                    aq1.add(cur);
                }
            }

            // 가장 자리 치즈 지우기, 그래프 내 치주 개수 셌던 것도 업데이트
            int Qsize2 = deleteCheese.size();
            for (int i = 0; i < Qsize2; i++) {
                Coordinate9 cur = deleteCheese.poll();
                graph[cur.x][cur.y] = '0';
                cheeseCnt--;
            }


        }
    }
}

class Coordinate9 {
    int x;
    int y;

    public Coordinate9(int x, int y){
        this.x = x;
        this.y = y;
    }
}