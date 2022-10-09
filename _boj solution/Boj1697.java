import java.io.*;
import java.util.*;
class Boj1697 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N,K;
	static int[] map;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}


	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		map[N]=0;
		q.add(N);
		int current;
		while(!q.isEmpty()) {
			current=q.remove();
			if(current==K) break;
			addToQ(q,current);
		}
	}
	static void addToQ(Queue<Integer>q, int x) {
		if(inRange(x-1)) // next = x-1
			if(map[x-1]>map[x]+1){
				map[x-1]=map[x]+1;
				q.add(x-1);
			}
		if(inRange(x+1)) // next = x+1
			if(map[x+1]>map[x]+1){
				map[x+1]=map[x]+1;
				q.add(x+1);
			}
		if(inRange(2*x)) // next = 2*x
			if(map[2*x]>map[x]+1){
				map[2*x]=map[x]+1;
				q.add(2*x);
			}		
	}
	static boolean inRange(int x) {
		if(0<=x && x<100_001) return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		st=new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		
		map = new int[100_001];
		Arrays.fill(map, Integer.MAX_VALUE);
		
		bfs();
		System.out.println(map[K]);
	}
}
