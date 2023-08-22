package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2931 {
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); //�Է�
		int R =Integer.parseInt(st.nextToken()); //R ���Է�
		int C =Integer.parseInt(st.nextToken()); //C ���Է�
		int x=0, y=0; // ��ĭ��ġ
		int ex=0,ey=0,sx=0,sy=0, check =0,n=0,so=0,w=0,e=0; //��ĭ �ֺ� ���� �Է� �� üũ
		boolean ck=false;
		String North = "|14+";
		String South = "|23+";
		String West = "-+12";
		String East = "-+34";
		map = new char[R][C]; //���� �Է�
		for(int i = 0 ; i < R ; i++) {
			String s = br.readLine();
			map[i]=s.toCharArray();
		} //���� �Է� �� 
		boolean findAnswer = false; //���� ����
		babo: for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) { //��� ���� ��ȸ
				
				if(map[i][j]!='.' && map[i][j]!='M'  && map[i][j]!='Z') { //���� ã���� �� ���θ��� �ֺ����� ��ȸ
					if(map[i][j]=='+') {
						if(j+1<C && map[i][j+1]=='.'  ) { 
							findAnswer = true;	x=i; y=j+1;
						}
						else if(j-1>=0 && map[i][j-1]=='.'  ) { 
							findAnswer = true;	x=i; y=j-1;
						}
						else if(i+1<R && map[i+1][j]=='.'  ) { 
							findAnswer = true;	x=i+1; y=j;
						}
						else if(i-1>=0 && map[i-1][j]=='.'  ) { 
							findAnswer = true;	x=i-1; y=j;
						}
					}
					else if(map[i][j]=='|') {  
						if(i+1<R && map[i+1][j]=='.'  ) { 
							findAnswer = true; x=i+1; y=j;
						}
						else if(i-1>=0 && map[i-1][j]=='.'  ) { 
							findAnswer = true;x=i-1; y=j;
						}
					}
					
					else if(map[i][j]=='-') {
						if(j+1<C && map[i][j+1]=='.'  ) { 
							findAnswer = true;x=i; y=j+1;
							
						}
						else if(j-1>=0 && map[i][j-1]=='.'  ) { 
							findAnswer = true; x=i; y=j-1;
						}
					}
					
					else if(map[i][j]=='1') {
						if(j+1<C && map[i][j+1]=='.'  ) { 
							findAnswer = true; x=i; y=j+1;
						}
						else if(i+1 <R && map[i+1][j]=='.'  ) { 
							findAnswer = true;	x=i+1; y=j;
						}
					}
					else if(map[i][j]=='2') {
						if(j+1 < C &&  map[i][j+1]=='.'  ) { 
							findAnswer = true; x=i; y=j+1;
						}
						else if(i-1 >=0 && map[i-1][j]=='.'  ) { 
							findAnswer = true; x=i-1; y=j;
						}
					}
					else if(map[i][j]=='3') {
						if(j-1 >=0 && map[i][j-1]=='.'  ) { 
							findAnswer = true; x=i; y=j-1;
						}
						else if(i-1 >=0 && map[i-1][j]=='.'  ) { 
							findAnswer = true; x=i-1; y=j;
						}
					}
					else if(map[i][j]=='4') {
						if(i+1 <R && map[i+1][j]=='.'  ) { 
							findAnswer = true; x=i+1; y=j;
						}
						else if( j-1 <C && map[i][j-1]=='.'  ) { 
							findAnswer = true; x=i; y=j-1;
						}
					}
				}else continue; //�ƴϸ� �ǳʶٱ�
				if(findAnswer) break babo;  //���� ã����
			}
		}
		if(x-1>=0 && North.contains(String.copyValueOf(new char[] { map[x-1][y]}))) {
			check++;
			n++;
		}
		if(x+1 < R && South.contains(String.copyValueOf(new char[] { map[x+1][y]}))) {
			check++;
			so++;
		}
		if(y-1 >=0 && West.contains(String.copyValueOf(new char[] { map[x][y-1]}))) {
			check++;
			w++;
		}
		if(y+1<C && East.contains(String.copyValueOf(new char[] { map[x][y+1]}))) {
			check++;
			e++;
		}
		if(check==4)
			System.out.println((x+1)+" "+(y+1)+" +\n");
		else if(n==1 && so==n) {
			System.out.println((x+1)+" "+(y+1)+" |\n");
		}else if(so==1 && so==e) {
			System.out.println((x+1)+" "+(y+1)+" 1\n");
		}else if(w==1 && e==w) {
			System.out.println((x+1)+" "+(y+1)+" -\n");
		}else if(n==1 && so==n) {
			System.out.println((x+1)+" "+(y+1)+" |\n");
		}else if(n==1 && n==e) {
			System.out.println((x+1)+" "+(y+1)+" 2\n");
		}else if(n==1 && w==n) {
			System.out.println((x+1)+" "+(y+1)+" 3\n");
		}else if(so==1 && so==w) {
			System.out.println((x+1)+" "+(y+1)+" 4\n");
		}
		//��� ��
	}
}

