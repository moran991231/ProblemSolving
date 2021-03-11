package done;


import java.io.*;
import java.util.StringTokenizer;

public class Boj_15650 {
	static int N,M;
	static int[] arr;
	static 	StringBuilder sb = new StringBuilder(200);
	
	static void dfs(int num, int idx){
		if (idx == M) {
			for(int i=0; i<M; i++)
				sb.append(arr[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int n=num; n<=N; n++ ) {
			arr[idx]=n;
			dfs(n+1, idx+1);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		br.close();
		arr = new int[M];
		dfs(1,0);
		System.out.println(sb.toString());		
		
	}

}
