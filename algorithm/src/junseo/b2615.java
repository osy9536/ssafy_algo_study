package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 오목게임
 * 1) 가로줄과 세로줄에 1~19 번호가 붙어있는 오목판
 * 2) 흰검, 바둑알을 교대로 놓아서 5개의 같은 색 알이 직선,대각을 이루면 이김
 * 3) 6알 이상 -> x
 */
public class b2615 {

    public static void main(String[] args) throws Exception {
        //////////////////////////////////////////////////////////////
        // 테스트 후 아래 파일 입력을 표준입력으로 처리하는 문장은 주석 처리해주세요!!!! ( System.setIn처리 코드 )
        //////////////////////////////////////////////////////////////
        //System.setIn(new FileInputStream("Test5.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][] arr = new int [20][20];
        StringTokenizer st;
        for(int i = 0;i<19;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<19;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//		/////////////////////////////////////////////////////////////
//		int[] dx = {1,1,0,1}; // 오른쪽위대각,오른쪽아래대각,아래,오른쪽
//		int[] dy = {-1,1,1,0};
        int[] dx = {0,1,1,-1}; // 오른쪽위대각,오른쪽아래대각,아래,오른쪽
        int[] dy = {1,0,1,1};
        int nx,ny;
        int cnt = 0;
        for(int i = 0;i<19;i++) {
            for(int j = 0;j<19;j++) {
                if(arr[i][j] == 0) continue;

                //////////////////////////////////////

                cnt = 1;

                for(int k = 0; k<4;k++) {
                    nx = i+dx[k];
                    ny = j+dy[k];
                    cnt = 1;
                    while(nx<19 && nx>=0&&ny<19&&ny>=0) {
                        if(arr[nx][ny] == arr[i][j]) {
                            nx +=dx[k];
                            ny +=dy[k];
                            cnt++;
                        }
                        else break;
                    }
/*					nx = i-dx[k];
					ny = j-dy[k];
					if(nx<19 && nx>=0&&ny<19&&ny>=0) {
						if(arr[nx][ny] == arr[i][j]) cnt=0;
					}*/
                    if(cnt == 5) {
                        System.out.printf("%d\n%d %d",arr[i][j],i+1,j+1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}

