package done;

import java.io.*;
import java.util.*;

class Boj_9372 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)	);
	static int N, M;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static void read() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		System.out.println(N-1);
		for(int i=0; i<M; i++) 
			br.readLine();

		
	}
	public static void main(String[] args) throws IOException {
		int T = stoi(br.readLine()	);
		
		for(int i=0; i<T; i++) {
			read();
		}
	}

}
