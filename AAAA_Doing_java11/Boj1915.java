import java.io.*;
import java.util.*;

class Boj1915 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[][] map;
	static final int[] dr= {-1,-1,0}, dc = {0,-1,-1};

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=1; j<=M; j++) {
				map[i][j] = line[j-1]-'0';
			}
		}
		int max=0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(map[i][j]==0) continue;
				int min = Math.min(map[i-1][j-1],Math.min(map[i-1][j],map[i][j-1]));
				
				map[i][j] = Math.max(map[i][j], min+1);
				max = Math.max(max, map[i][j]);
			}
		}
		System.out.println(max*max);
	}
}
