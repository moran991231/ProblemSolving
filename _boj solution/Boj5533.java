package round6;

import java.io.*;
import java.util.*;

class Boj5533 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N ;
	static int[][] nums;
	static int[] total, temp;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		N = stoi(br.readLine());
		nums = new int[N][3];
		total = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i][0] = stoi(st.nextToken());
			nums[i][1] = stoi(st.nextToken());
			nums[i][2] = stoi(st.nextToken());
		}
		
		for(int k=0;k<3;k++) {
			temp = new int[101];
			for(int i=0; i<N; i++) {
				temp[nums[i][k]]++;
			}
			for(int i=0; i<N; i++) {
				if(temp[nums[i][k]]==1) {
					total[i] += nums[i][k];
				}
			}
		}
		
		for(int i=0; i<N; i++)
			sb.append(total[i]).append('\n');
		System.out.println(sb.toString());
	}

}
