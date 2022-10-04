import java.io.*;
import java.util.*;

class Boj1236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static char[][] castle;
	static final char BLANK = '.';

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static int solve() {
		boolean[] rows = new boolean[N], cols=new boolean[M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(castle[i][j] != BLANK) {
					rows[i]=true;
					cols[j]=true;
				}
			}
		}
		int emptyRow=0, emptyCol=0;
		for(boolean r:rows)
			if(r==false) emptyRow++;
		for(boolean c:cols)
			if(c==false) emptyCol++;
		
		return Math.max(emptyRow, emptyCol);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M =stoi(st.nextToken());
		castle = new char[N][];
		for(int i=0; i<N; i++)
			castle[i] = br.readLine().toCharArray();
		
		System.out.println(solve());
	}
}
