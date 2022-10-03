package round6;

import java.io.*;
import java.util.*;

class Boj10409 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken()), T = stoi(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int sum=0, cnt=0;
		for(int i=0; i<N; i++) {
			sum+= stoi(st.nextToken());
			if(sum<=T) {
				cnt++;
			}else
				break;
		}
		System.out.println(cnt);
	}

}
