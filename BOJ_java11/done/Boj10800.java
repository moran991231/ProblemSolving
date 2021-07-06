package done;
import java.io.*;
import java.util.*;

class Boj10800 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int [][] balls;
	static int[] sSum = new int[2001];
	static ArrayList<Integer>[] colorSize = new ArrayList[200_001]; // colorSize[color] = sizeList;
	static int[][] csSum = new int[200_001][]; // csSum[color] = sizeSum[]
	static final int COLOR = 0, SIZE=1;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	public static void solve() {
		int smallerTotal, idx,ret;
		for(int[] ball : balls) {
			smallerTotal = sSum[ball[SIZE]-1];
			idx = upperBound(colorSize[ball[COLOR]], ball[SIZE]-1);
			if(idx<0) {
				ret = smallerTotal;
			}else {
				ret = smallerTotal - csSum[ball[COLOR]][idx];
			}
			sb.append(ret).append('\n');
		}
	}
	
	public static int upperBound(ArrayList<Integer> sizes, int target) {
		int b=0, e=sizes.size()-1,p=0;
		if(e<0)return -1;
		if(target<sizes.get(b)) return -1;
		if(sizes.get(e)<=target) return e;
		
		while(b<=e) {
			p=(b+e+1)/2;
			if(target>=sizes.get(p)) {
				if(b==p) {					
					break;
				}
				b=p;
				
			}else {
				e=p-1;
			}
		}
		
		return p;
	}

	public static void main(String[] args) throws IOException {
		/*
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> lst = new ArrayList<>();
		for(int i=0, n=st.countTokens(); i<n; i++)
			lst.add(stoi(st.nextToken()));
		int x=0;
		while((x = stoi(br.readLine()))!=-1) {
			System.out.println("ub "+upperBound(lst, x));
		}
		*/
		sb.setLength(0);
		N = stoi(br.readLine());
		Arrays.fill(sSum, 0);
		balls = new int[N][2];
		
		for(int i=1; i<=200_000; i++)
			colorSize[i] = new ArrayList<Integer>();
		
		int c,s;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			balls[i][COLOR]=c = stoi(st.nextToken());
			balls[i][SIZE]= s = stoi(st.nextToken());
			sSum[s]+= s;
			colorSize[c].add(s);
		}
		
		for(int i=1; i<=2000; i++)
			sSum[i]+=sSum[i-1];
		
		ArrayList<Integer> sizeList;
		for(int i=1; i<=200_000; i++) {
			sizeList = colorSize[i];
			int size = sizeList.size();
			if(size==0) continue;
			Collections.sort(sizeList);
			csSum[i] = new int[size];
			csSum[i][0] = sizeList.get(0);
			for(int j=1; j<size; j++) {
				csSum[i][j] = csSum[i][j-1]+sizeList.get(j);
			}
			
		}
		solve();
		System.out.println(sb.toString());
	}
}
