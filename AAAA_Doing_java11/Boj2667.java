import java.io.*;
import java.util.*;

class Boj2667 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] village;
	static final int[] dr = {0,0,-1,1},dc= {-1,1,0,0};

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static boolean isNeighbor(int r, int c) {
		if(!(0<=r && r<N && 0<=c && c<N)) return false;
		if(village[r][c]!='1') return false;
		return true;
	}
	static int bfs(int r, int c) {
		int cnt=0;
		int rr,cc;
		
		Queue<int[]> q = new LinkedList<>();
		village[r][c]='0';
		cnt++;
		q.add(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] home = q.remove();
			for(int i=0; i<4; i++) {
				rr=home[0]+dr[i];
				cc = home[1]+dc[i];
				if(isNeighbor(rr, cc)) {
					village[rr][cc]='0';
					cnt++;
					q.add(new int[] {rr,cc});
				}
			}
		}
		
		return cnt;
		
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		N = stoi(br.readLine());
		village = new char[N][];
		for(int i=0; i<N; i++)
			village[i] = br.readLine().toCharArray();
		
		ArrayList<Integer> lst = new ArrayList<>(); 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(village[i][j]=='1')
					lst.add(bfs( i,j));
			}
		}
		Collections.sort(lst);
		sb.append(lst.size()).append('\n');
		for(int cnt: lst)
			sb.append(cnt).append('\n');

		System.out.println(sb.toString());
	}
}
