
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b2583{

    static boolean[][] paper,isVisited;
    static int[] dx = {0,-1,0,1},dy = {-1,0,1,0};
    static int X,Y,width;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Y=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        int count=0,cnt=0,num = Integer.parseInt(st.nextToken());
        paper = new boolean[X][Y];
        //입력완료
        for(int k = 0 ; k < num ; k++){
            st = new StringTokenizer(br.readLine());

            int xs = Integer.parseInt(st.nextToken());
            int ys = Integer.parseInt(st.nextToken());
            int xe = Integer.parseInt(st.nextToken());
            int ye = Integer.parseInt(st.nextToken());

            for(int i = xs ; i < xe ; i++)
                for (int j = ys ; j < ye ; j++){
                    paper[i][j] = true;
                }
        }
        isVisited = new boolean[X][Y];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < X ; i++){
            for(int j = 0 ; j < Y ; j++){
                if(!paper[i][j] && !isVisited[i][j]) {
                    isVisited[i][j]=true;
                    width=1;
                    BFS(i,j);
                    if(width!=0) {
                        ans.add(width);
                        cnt++;
                    }
                }
            }
        }
        Collections.sort(ans);
        System.out.println(cnt);
        for(int i = 0 ; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");

    }
    private static void BFS(int x, int y) {
        for(int d = 0 ; d < 4 ; d++){
            int xCheck = x+dx[d];
            int yCheck = y+dy[d];
            if(xCheck >= 0 && xCheck < X
                    && yCheck>=0 && yCheck < Y){

                if(!paper[xCheck][yCheck] && !isVisited[xCheck][yCheck]) {

                    isVisited[xCheck][yCheck] = true;
                    width++;
                    BFS(xCheck, yCheck);
                }
            }
        }
    }

}
