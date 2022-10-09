package done;


import java.io.*;
import java.util.StringTokenizer;

public class Boj_1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[]A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int max=-1001;
		int sum=0;
		for(int i=0; i<N; i++) {
			sum += A[i];
			max = Math.max(max, sum);
			sum = (sum>=0)? sum:0;
		}
		
		System.out.println(max);		
	}

}
