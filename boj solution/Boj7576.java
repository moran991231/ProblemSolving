import java.io.*;
import java.util.*;

class Boj7576 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int M,N, numTomatoes;
	static byte[][] map;
	static Queue<Tomato>q = new LinkedList<>();
	static final int[] dr= {0,0,-1,1}, dc = {-1,1,0,0};

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static byte stob(String s) {
		return Byte.parseByte(s);
	}
	
	static class Tomato{
		int r,  c;
		Tomato(int i, int j){
			r=i;
			c=j;
		}
	}
	
	static void ripenTomato(int r, int c) {
		if(r<0 || M<= r || c<0 || N<=c)
			return ;
		if(map[r][c]!=0) return;
		map[r][c]=1;
		numTomatoes--;
		q.add(new Tomato(r,c));
		
	}
	
	static int bfs() {
		int day=-1;
		
		while(!q.isEmpty()) {
			int cnt = q.size();
			for(int n=0;n<cnt; n++) {
				Tomato t = q.remove();
				
				for(int i=0; i<4; i++	)
					ripenTomato(t.r+dr[i],t.c+dc[i]);
			}
			day++;
		}
		if(numTomatoes>0) day=-1;
		
		return day;
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M= stoi(st.nextToken());
		map = new byte[M][N];
		numTomatoes=0;
		q.clear();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = stob(st.nextToken());
				if(map[i][j]==0)
					numTomatoes++;
				else if(map[i][j] == 1)
					q.add(new Tomato(i,j));
					
			}
		}
		
		int day= bfs();
		System.out.println(day);
		
		

	}
}
