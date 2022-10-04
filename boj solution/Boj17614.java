package round7;

import java.io.*;
import java.util.*;

class Boj17614 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] game,pow10;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int cnt369(int n) {
		int cnt=0;
		while(n!=0) {
			switch(n%10) {
			case 3:
			case 6:
			case 9:
				cnt++;
				break;
			default:
				break;
			}
		}
		return cnt;
	}
	static void makeGame() {
		game = new int[8];
		pow10 = new int[8];
		pow10[0]=1;
		for(int i=1; i<=7; i++)
			pow10[i] = pow10[i-1]*10;
		
		game[1]=3;
		for(int i=2; i<=7;i++) {
			game[i] = 10*game[i-1]+3*pow10[i-1];
		}
		
	}

	public static void main(String[] args) throws IOException{
		if(game==null) makeGame();
		
		int N = stoi(br.readLine());
		
		long ret=0;
		int rem = N%10;
		if(rem==3||rem==6||rem==9)
			ret++;
		N/=10;
		for(int i=1; i<=7;i++) {
			rem = N%10;
			N/=10;
			if(rem==3||rem==6||rem==9)
				ret += rem*game[i];
		}
		
		System.out.println(ret);
	}

}