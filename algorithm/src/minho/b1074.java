package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1074 {
	static int answer=0,r,c;
	static boolean finded=false;
	public static void re(int h,int x,int y) {
		if(h==2 && !finded) {
			if(x<=r && y<=c && x+1>=r && y+1>=c) {
				if(r==x) {
					if(c==y) {answer+=1;finded=true;return;}
					else if(c==y+1) {answer+=2;finded=true;return;}
				}else {
					if(c==y) {answer+=3;finded=true;return;}
					else if(c==y+1)	{answer+=4;finded=true;return;}
				}
			}
			else {
				answer+=4;
				return;
			}
		}else if(!finded){
			if(!finded && r<x+(h/2) && c <y+(h/2) )	re(h/2,x,y);
			else if(!finded && r<x+(h/2) && c <y+h) {answer+=(h/2)*(h/2); re(h/2,x,y+(h/2));}
			else if(!finded && r<x+h && c <y+(h/2)) {answer+=2*((h/2)*(h/2)); re(h/2,x+(h/2),y);}
			else if(!finded && r<x+h && c <y+h) {answer+=3*((h/2)*(h/2)); re(h/2,x+(h/2),y+(h/2));}
		}
		return;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int n = (int)Math.pow(2, N);	
		
		re(n,0,0);
		System.out.println(answer-1);
	}
}







