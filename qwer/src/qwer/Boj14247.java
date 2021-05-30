package qwer;

import java.io.*;
import java.util.*;

class Boj14247 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st1,st2;
	
	static int N;
	static Tree[] trees;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static class Tree implements Comparable<Tree>{
		int height, grow;
		
		Tree(int h, int g){
			height=h;
			grow=g;
		}
		
		public int compareTo(Tree t) {

			return grow-t.grow;
		}
		
	}
	
	
	public static void func() {
		for(Tree t:trees) 
			t.height += t.grow*(N-1);
		
	}

	public static void main(String[] args) throws IOException{
		N = stoi(br.readLine());
		st1 = new StringTokenizer(br.readLine());
		st2 = new StringTokenizer(br.readLine());
		trees = new Tree[N];
		for(int i=0; i<N; i++) {
			trees[i] =new Tree(stoi(st1.nextToken()	), stoi(st2.nextToken()));
		}
		Arrays.sort(trees);
		
		long  ret=0;
		for(int i=N-1; 0<=i ; i-- ) {
			ret += trees[i].height;
			ret += trees[i].grow*(i);
		}
		System.out.println(ret);
	}

}