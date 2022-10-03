package qwer;

import java.io.*;
import java.util.*;

class Boj14468 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static char[] way;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		way = br.readLine().toCharArray();
		int cnt=0;
		
		for(int i=0; i<52; i++) {
			char cowi = way[i];
			if (cowi==0)
				continue;
			boolean[] cross = new boolean[26];
			
			for(int j=i+1; j<52; j++) {
				char cowj = way[j];
				if(cowi==cowj) {
					way[j]=0;
					break;
				}
				else if (cowj==0)
					continue;
				else {
					cowj-='A';
					cross[cowj] = !cross[cowj];
				}
				
			}
			for(boolean x:cross)
				if(x)cnt++;
			
		}
		System.out.println(cnt);
		
	}

}

