package algorithm.src.minho;

//월드컵 6987번
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b6987{
	static int[][] team = new int[6][3];
	static boolean result=false, err=false;
	static int matches=0;
	public static void checkIt(int home, int num) {
		if(result) return;
		if(matches==15) {
			result=true;
			for(int i=0;i<6;i++) {
				for(int j = 0 ; j<3;j++) {
					if(team[i][j]!=0) result = false;
				}
			}
			return ;
		}   			
		if(team[home][0]>0 && team[num][2]>0) { //home win
			team[home][0]--;
			team[num][2]--;
			matches++;
			if(num+1 <= 5) checkIt(home,num+1);
			else if(num+1 > 5) checkIt(home+1,home+2);
			matches--;
			team[home][0]++;
			team[num][2]++;
		}
		if(team[home][1]>0 && team[num][1]>0) { //home draw
			team[home][1]--;
			team[num][1]--;
			matches++;
			if(num+1 <= 5) checkIt(home,num+1);
			else if(num+1 > 5) checkIt(home+1,home+2);
			matches--;
			team[home][1]++;
			team[num][1]++;
		}
		if(team[home][2]>0 && team[num][0]>0) { //home lose
			team[home][2]--;
			team[num][0]--;
			matches++;
			if(num+1 <= 5) checkIt(home,num+1);
			else if(num+1 > 5) checkIt(home+1,home+2);
			matches--;
			team[home][2]++;
			team[num][0]++;
		}
		return ;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t =0 ; t < 4 ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 6 ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					team[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			result=false;
						
			checkIt(0,1);
			
			if(result) {
				System.out.print(1+" ");
			}else {
				System.out.print(0+" ");
			}
		}
	}	
}
