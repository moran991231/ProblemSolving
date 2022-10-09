package round6;

import java.io.*;
import java.util.*;

class Boj9657 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean[] sk;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static void makeWinner() {
		sk = new boolean[1001]; //true면 상근이 이김
		sk[1]=sk[3]=sk[4]=true;
		sk[2]=false;
		
		for(int i=4; i<=1000;i++) {
			if(sk[i-1]&&sk[i-3]&&sk[i-4])
				sk[i]=false;
			else
				sk[i]=true;
		}
		
	}

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		if(sk==null	)makeWinner();
		int N = stoi(br.readLine());
		System.out.println(sk[N]?"SK":"CY");
	}

}
