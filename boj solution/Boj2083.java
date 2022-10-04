package adsf;

import java.io.*;
import java.util.*;

class Boj2083 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static final String JUN = " Junior\n", SEN = " Senior\n";
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		String name;
		int age, weight;
		while(true) {
			st = new StringTokenizer(br.readLine());
			 name = st.nextToken();
			if(name.charAt(0) == '#') break;
			sb.append(name);
			age = stoi(st.nextToken());
			weight = stoi(st.nextToken());
			if(age>17 || weight>=80)
				sb.append(SEN);
			else
				sb.append(JUN);
		}
		System.out.println(sb.toString());
		
	}

}
