import java.io.*;
import java.util.*;

class BOj2666 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, min;
	static int[] cmd= new int[20];

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	
	static void divide(int a, int b, int depth, int sum) {
		if(depth ==N) {
			min = Math.min(min, sum);
			return;
		}
		if(sum>=min)
			return;
		
		int door = cmd[depth++];
		if(door<=a) divide(door,b,depth,sum+a-door);
		else if (b<=door) divide(a,door,depth,sum+door-b);
		else {
			divide(door,b,depth,sum+door-a);
			divide(a,door,depth,sum+b-door);
		}
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		br.readLine();
		st = new StringTokenizer(br.readLine());
		int a = stoi(st.nextToken());
		int b = stoi(st.nextToken());
		{
			int min = Math.min(a, b), max = Math.max(a, b);
			a=min;
			b=max;
		}
		N=stoi(br.readLine());
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			cmd[i] = stoi(str);			
		}
		
		min =Integer.MAX_VALUE;
		divide(a,b,0,0);
		System.out.println(min);
		
	}
}
