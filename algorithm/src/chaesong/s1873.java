import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_상호 {
	static char field[][];
	static int H, W, N;
	static int car[];
	static int stx, sty;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			field = new char[H][W];
			for(int i = 0; i < H; i++) {
				String line = br.readLine();
				for(int j = 0; j < W; j++) {
					field[i][j] = line.charAt(j);
				}
			}
			N = Integer.parseInt(br.readLine());
			stx = 0; sty = 0; 
			whereIs(field);
			car = new int[2]; car[0] = stx; car[1] = sty;
			String line = br.readLine();
			for(int i = 0; i < N; i++) {
				char s = line.charAt(i);
				move(s, car);
			}
			if(t > 1) sb.append("\n");
			sb.append("#" + t +" ");
			for(int i = 0; i < H; i++) {
				if(i >= 1) sb.append("\n");
				for(int j = 0; j < W; j++) {
					sb.append(field[i][j]);
				}
			}
		}
		System.out.println(sb);
	}
	//전차위치 파악
	static void whereIs(char field[][]) {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if (field[i][j] == '^' || field[i][j] == 'v' || field[i][j] == '<' || field[i][j] == '>') {
					stx = i; sty = j; 
				}
			}
		}
	}
	//명령 처리하기
	static void move(char s, int car[]) {
		switch(s) {
		case 'U':
			if(car[0]-1 >= 0 &&field[car[0]-1][car[1]] == '.') {
				field[car[0]-1][car[1]] = '^';
				field[car[0]][car[1]] = '.';
				car[0] -= 1;
			}
			else {
				field[car[0]][car[1]] = '^';
			}
			break;
		case 'D':
			if(car[0]+1 < H && field[car[0]+1][car[1]] == '.') {
				field[car[0]+1][car[1]] = 'v';
				field[car[0]][car[1]] = '.';
				car[0] += 1;
			}
			else {
				field[car[0]][car[1]] = 'v';
			}
			break;
		case 'L':
			if(car[1]-1 >= 0 && field[car[0]][car[1]-1] == '.') {
				field[car[0]][car[1]-1] = '<';
				field[car[0]][car[1]] = '.';
				car[1] -= 1;
			}
			else {
				field[car[0]][car[1]] = '<';
			}
			break;
		case 'R':
			if(car[1]+1 < W && field[car[0]][car[1]+1] == '.') {
				field[car[0]][car[1]+1] = '>';
				field[car[0]][car[1]] = '.';
				car[1] += 1;
			}
			else {
				field[car[0]][car[1]] = '>';
			}
			break;
		case 'S':
			shoot(car);
			break;
		}
	}
	//포탄 발사
	static void shoot(int car[]) {
		char now = field[car[0]][car[1]];
		switch(now) {
		case '^':
			if(car[0]-1 >= 0) {
				for(int i = car[0]-1; 0 <= i; i--) {
					if(field[i][car[1]] == '#') return;
					if(field[i][car[1]] == '*') {
						field[i][car[1]] = '.';
						return;
					}
				}				
			}
			break;	
		case 'v':
			if(car[0]+1 < H) {
				for(int i = car[0]+1; i < H; i++) {
					if(field[i][car[1]] == '#') return;
					if(field[i][car[1]] == '*') {
						field[i][car[1]] = '.';
						return;
					}
				}				
			}
			break;
		case '<':
			if(car[1]-1 >= 0) {
				for(int i = car[1]-1; 0 <= i; i--) {
					if(field[car[0]][i] == '#') return;
					if(field[car[0]][i] == '*') {
						field[car[0]][i] = '.';
						return;
					}
				}				
			}
			break;
		case '>':
			if(car[1]+1 < W) {
				for(int i = car[1]+1; i < W; i++) {
					if(field[car[0]][i] == '#') return;
					if(field[car[0]][i] == '*') {
						field[car[0]][i] = '.';
						return;
					}
				}				
			}
			break;
		}
	}
}
