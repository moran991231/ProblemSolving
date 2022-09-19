import java.io.*;
import java.util.*;

class Boj1713 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[] rec;
	static Candidate[] cands;
	

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static class Candidate implements Comparable<Candidate>{
		int id,num,time;
		boolean isNominated=false;
		Candidate(int id,int n, int t){
			this.id=id;
			num = n;
			time=t;
		}
		
		void recommend() {
			num++;
		}
		void delete() {
			num=0;
			isNominated=false;
		}
		Candidate add(int t) {
			num=1;
			isNominated=true;
			time=t;
			return this;
		}

		@Override
		public int compareTo(Candidate o) {
			// TODO Auto-generated method stub
			if(num == o.num)
				return time-o.time;
			return num-o.num;
		}
		
	}
	
	public static  void chooseCandidates() {
		List<Candidate> frames = new ArrayList<>(N);

		Candidate cand;
		for(int t=0; t<M;t++) {
			cand = cands[rec[t]];
			
			if(cand.isNominated)
				cand.recommend();
			else if(frames.size()<N)
				frames.add(cand.add(t));
			else {
				Collections.sort(frames);
				frames.get(0).delete();
				frames.set(0, cand.add(t));
			}
			
		}
		frames.sort((a,b)->(a.id-b.id));
		for(Candidate c: frames)
			sb.append(c.id).append(' ');
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		N = stoi(br.readLine());
		M = stoi(br.readLine());
		rec = new int[M];
		cands = new Candidate[101];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			rec[i] = stoi(st.nextToken());
			if(cands[rec[i]]==null)
				cands[rec[i]]= new Candidate(rec[i],0,-1);
		}
		chooseCandidates();
		System.out.println(sb.toString());
		
	}
}
