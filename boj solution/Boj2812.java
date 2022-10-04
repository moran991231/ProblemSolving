package done;
import java.io.*;
import java.util.*;

class Boj2812 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N,K;
	static char[] nums;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static void solve() {
		int size = nums.length;
		int last=-1;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->((nums[a]==nums[b]? a-b: (int)nums[b]-(int)nums[a])));

		int k=size-K;
		int idx;
		for(int i=0; i<size; i++) {
			maxHeap.add(i);
			if(i==size-k) {
				k--;
				while(!maxHeap.isEmpty()) {
					idx=maxHeap.remove();
					if(last < idx) {
						sb.append(nums[idx]);
						last=idx;
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		nums = br.readLine().toCharArray();
		
		solve();
		System.out.println(sb.toString());
	}
}
