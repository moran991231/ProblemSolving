import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, Target;
	static int[] parentOf;
	static ArrayList<Integer>[] tree;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		N = stoi(br.readLine());
		parentOf = new int[N];
		tree = new ArrayList[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			parentOf[i] = stoi(st.nextToken());
		}
		Target = stoi(br.readLine());
		
		
		
	}
}
