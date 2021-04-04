package done;

import java.io.*;
import java.util.*;

class Boj_1932 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] tri;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static boolean inRange (int x, int min, int max) {
		if(min <= x && x<max) return true;
		else return false;
	}
	
	static int stepDown() {
		int max=0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {				
				int temp1 = tri[i-1][j-1];
				int temp2 = tri[i-1][j];
				tri[i][j] += Math.max(temp1, temp2);
			}
		}
		for(int j=1; j<=N; j++)
			max = Math.max(max, tri[N][j]);
		return max;
	}

	public static void main(String[] args) throws IOException{
		N = stoi(br.readLine());
		
		tri = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=i; j++) {
				tri[i][j] = stoi(st.nextToken());
			}
		}
		
		System.out.println(stepDown());
		
	}

}

