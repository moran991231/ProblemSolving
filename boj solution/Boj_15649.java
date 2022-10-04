package done;


import java.util.Scanner;

public class Boj_15649 {
	int N,M;
	StringBuilder sb = new StringBuilder();
	int[] result = new int[9];
	boolean[] isEnabled = new boolean[9];
	
	void append_result() {
		for(int i=1; i<=M; i++) 
			sb.append(result[i]).append(' ');
		sb.append('\n');
	}
	void dfs(int val, int idx) {
		if(idx>0) {
			result[idx] = val;
			isEnabled[val]= false;
		}
		if (idx == M) {
			append_result();
//			result[idx]=0;
			isEnabled[val]=true;
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if( isEnabled[i])
				dfs(i, idx+1);
		}
//		result[idx]=0;
		isEnabled[val]=true;
	}
	
	void main_func() {
		Scanner sc = new Scanner (System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.close();
		for(int i=0; i<9;i++)
			isEnabled[i]=true;
		dfs(0,0);
		System.out.println(sb.toString());
		
	}

	public static void main(String[] args) {
		new Boj_15649().main_func();
	}

}
