package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class b2615 {
    static int[][] pan = new int[21][21];
    static int[][] direction= {{0,1},{1,0},{1,1},{-1,1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                pan[i][j] = Integer.parseInt(st.nextToken());
            }
        } //입력 끝
        for(int j =1;j<=19;j++) {
        	for(int i=1;i<=19;i++) {
        		if(pan[i][j]==2 || pan[i][j]==1) {
	        		for(int d=0;d<4;d++) {
	        			int ax=i, ay=j, cnt=1;
        			   	while(true) {
	        				ax += direction[d][0];
	        				ay += direction[d][1];
	        				if(ax >=1 && ax<=19 && ay >=1 && ay<=19){
	        					if(pan[ax][ay]==pan[i][j]) cnt++;
	        					else break;
	        				}else break;
	        			}
        			   	ax=i;
        			   	ay=j;
	        			while(true) {
	        				ax -= direction[d][0];
	        				ay -= direction[d][1];
	        				if(ax >=1 && ax<=19 && ay >=1 && ay<=19){
	        					if(pan[ax][ay]==pan[i][j]) cnt++;
	        					else break;
	        				}else break;
	        			}
	        			if(cnt==5) {
	        				System.out.println(pan[i][j]);
	        				System.out.println(i+" "+j);
	        				return;
	        			}
	        		}
        		}
        	}
        }
        System.out.println(0);
    }
}
