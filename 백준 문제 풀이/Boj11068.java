package round7;

import java.io.*;
import java.util.*;

class Boj11068 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static boolean isEnabled(ArrayList<Integer> num) {
		int len=num.size();
		for(int i=0; i<=len/2;i++) {
			if(num.get(i)!= num.get(len-i-1))
				return false;
		}
		return true;
	}
	
	static int numPal(int n) {
		ArrayList<Integer> num = new ArrayList<>();
		int temp=n;
		for(int i=2;  i<=64;i++) {
			num.clear();
			n=temp;
			while(n!=0) {
				num.add(n%i);
				n/=i;
			}
			if(isEnabled(num)) return 1;
			
		}
		 
		
		return 0;
	}

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		int T = stoi(br.readLine());
		for(int t=0;t<T;t++) {
			int N = stoi(br.readLine());
			sb.append(numPal(N)).append('\n');
		}
		System.out.println(sb.toString());
		
	}

}