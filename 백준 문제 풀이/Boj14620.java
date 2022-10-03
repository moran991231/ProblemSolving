package done;
import java.io.*;
import java.util.*;

class Boj14620 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, NN;
	static int[][] map;
	static boolean[][] disabled;
	static int min;

	static final int[] dx = {0,0,0,1,-1},dy= {0,1,-1,0,0};
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static boolean floweringEnabled(int point) {
		int x = point/N, y=point%N;
		if(x==0 || x==N-1 || y==0 || y==N-1) return false;
		
		for(int i=0; i<5; i++)
			if(disabled[x+dx[i]][y+dy[i]]) return false;
		
		return true;
	}
	static int layFlower(int point, boolean fill) {
		int x = point/N, y=point%N;
		int sum=0;
		for(int i=0; i<5; i++) {
			sum += map[x+dx[i]][y+dy[i]];
			disabled[x+dx[i]][y+dy[i]] =fill;
		}
		return sum;
	}
	static void dfs(int point, int depth, int sum) {
		
		if(point>0) {
			
			sum += layFlower(point, true);		
			depth++;
		}
			
		
		
		if(min==0) return;
		if(depth ==3) {
			min = Math.min(min, sum);
			layFlower(point,false);
			return;
		}
		
		for(int i=point+1; i<NN; i++) {
			if(floweringEnabled(i))
				dfs(i,depth,sum);
		}
		
		if(point>0)
			layFlower(point,false);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		N = stoi(br.readLine());
		NN =N*N;
		map = new int[N][N];
		disabled = new boolean[N][N];
		min=Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		
		dfs(0,0,0);
		System.out.println(min);

	}
}
