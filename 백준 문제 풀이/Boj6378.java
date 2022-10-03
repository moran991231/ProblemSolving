package round8;

import java.io.*;
import java.util.*;

class Boj6378 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		while (true) {
			char[] num = br.readLine().toCharArray();
			if (num.length == 1) {
				if (num[0] == '0')
					break;	
				sb.append(num[0]).append('\n');
				continue;
			}

			int ret = 0;
			for (char n : num)
				ret += n - '0';
			
			while(true) {
				if(ret/10 == 0) {
					sb.append(ret).append('\n');
					break;
				}
				int temp =0;
				while(ret !=0) {
					temp += ret%10;
					ret/=10;
				}
				ret=temp;
				
			}
			
		}
		System.out.print(sb.toString());
	}
}
