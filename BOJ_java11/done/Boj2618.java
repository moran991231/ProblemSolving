package done;

import java.io.*;
import java.util.*;

class Boj2618  {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, W;
	static int[][] dp;  //dp[i][j], i>j
	static Point[] inc;
	static int pathA, pathB;
	
	static class Point {
		int x, y,inc_num;
		
		Point(int n,int x, int y){
			inc_num=n;
			this.x=x;
			this.y=y;
		}
		
		 int getDist(Point i) {
			 return Math.abs(x-i.x)+ Math.abs(y-i.y);
		 }
		 int getDist(int r,int c) {
			 return Math.abs(x-r)+Math.abs(y-c);
		 }
		 
	}
	
	static class Dist implements Comparable<Dist>{
		int inc_num, dist;
		Dist(int n,int d){
			inc_num=n;
			dist=d;
		}
		
		public int compareTo(Dist d) {
			return dist-d.dist;
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	
	static void make_dp() {
		dp = new int[W][W];
		for(int i=0; i<W; i++) {
			for(int j=0; j<i; j++) {
				dp[i][j] = inc[i].getDist(inc[j]);
			}
		}
	}
	
	static void calc() {
		pathA=pathB=0;
//		Point pA= new Point(-1,1,1), pB= new Point(-1,N,N);
//		PriorityQueue<Dist> heap = new PriorityQueue<>();
		
	}
	public static void main(String[] args) throws IOException{
		N = stoi(br.readLine());
		W = stoi(br.readLine());
		inc = new Point[W];
		for(int i=0; i<W; i++) {
			st = new StringTokenizer(br.readLine());
			inc[i] = new Point(i,stoi(st.nextToken()), stoi(st.nextToken()));
		}
		
	}

}
