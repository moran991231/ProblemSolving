package qwer;

import java.io.*;
import java.util.*;

class Boj4388 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static long stol(String s) {
		return Long.parseLong(s);
	}

	static int countCarry(long a, long b) {
		
		int cnt=0;
		int carry=0;
		while(a>0||b>0) {
			carry += a%10+b%10;
			if(carry>=10) {
				carry=1;
				cnt++;
			}else
				carry=0;
			a/=10;
			b/=10;
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		long a=-1, b=-1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			a = stol(st.nextToken());
			b = stol(st.nextToken());
			if(a==0&& b==0) break;
			
			sb.append(countCarry(a,b)).append('\n');
			
		}
		System.out.print(sb.toString());
		
	}

}