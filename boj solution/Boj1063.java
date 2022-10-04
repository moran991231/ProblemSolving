import java.io.*;
import java.util.*;

class Boj1063 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Point{
		int r, c;
		Point(String s){
			c = s.charAt(0)-'A';
			r = 7-(s.charAt(1)-'1');
		}
		Point (Point p){
			r=p.r;
			c=p.c;
		}
		
		void move(String s) {
			oneChar(s.charAt(0));
			if(s.length()==1) return;			
			oneChar(s.charAt(1));
		}
		
		Point test(String s) {
			Point ret = new Point(this);
			ret.move(s);
			 return ret;
		}
		
		boolean equals(Point p) {
			if(p==null) return false;
			if(r==p.r && c==p.c) return true;
			return false;
		}
		
		boolean possible() {
			if(0<=r && r<8 && 0<=c && c<8) return true;
			return false;
		}
		private void oneChar(char ch) {
			switch(ch) {
			case 'R':
				c++;
				break;
			case 'L':
				c--;
				break;
			case 'B':
				r++;
				break;
			case 'T':
				r--;
				break;
			}
		}
		
		public String toString() {
			return String.format("%c%d", (char)(c+'A'),8-r);
		}
	
	
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		Point rock, king;
		st = new StringTokenizer(br.readLine());
		king = new Point(st.nextToken());
		rock = new Point(st.nextToken());
		int N = stoi(st.nextToken());
		
		Point test1,test2;
		String cmd;
		for(int i=0; i<N; i++) {
			cmd = br.readLine();
			
			test1 = king.test(cmd);
			if(test1.possible() == false) continue;
			if(rock.equals(test1) == false) {
				king.move(cmd);
				continue;
			}
			
			test2 = rock.test(cmd);
			if(test2.possible()==false) continue;
			king=test1;
			rock=test2;
			
		}
		System.out.println(king.toString());
		System.out.println(rock.toString());
		

	}
}
