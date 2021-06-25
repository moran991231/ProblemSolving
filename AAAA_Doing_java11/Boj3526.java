import java.io.*;
import java.util.*;

class Main_ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N,M;
	static Room[] rooms;
	static ArrayList<int[]>[] lobbies;
	
	static final int NEXT=0, COLOR=1;
	
	static class Room{
		public ArrayList<Integer> path =null;
		public boolean visited =false;
		
		
		public int isPrior(Room r, int addition) {
			if(this.path ==null) {
				this.path = new ArrayList<>();
				return 0;
			}
			int temp = path.size()-r.path.size()-1;
			if(temp<0) return -1;
			else if (temp>0) return 0;
			
			for(int i=0; i<path.size()-1;i++) {
				temp = path.get(i)-r.path.get(i);
				if(temp<0) return -1;
				else if (temp>0) return i;
			}
			temp = path.get(path.size()-1) - addition;
			if(temp<0) return -1;
			else  return path.size()-1;
			
			
		}
		public void update(Room r, int addition, int idx) {
			if(path == null)
				path = new ArrayList<>();
			if(idx==0) {
				path.clear();
				path.addAll(r.path);
				path.add(addition);
				
			}else {
				int size=path.size()-1;
				ArrayList<Integer>rpath = r.path;
				for(int i=idx; i<size;i++)
					path.set(i, rpath.get(i));
				path.set(size, addition);
			}
		}
		
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static void bfs() throws IOException {
		Queue<Integer> q = new LinkedList<>();
		rooms[1].visited=true;
		rooms[1].path = new ArrayList<>();
		q.add(1);
		Room r, next;
		int r_idx, update_idx;
		
		while(!q.isEmpty()) {
			r_idx=q.remove();
			if(r_idx==N)break;
			 r= rooms[r_idx];
			 
			for(int[] lobby: lobbies[r_idx]) {
				next = rooms[lobby[NEXT]];
				if(next.visited) {
					update_idx=next.isPrior(r, lobby[COLOR]);
					if(update_idx<0) continue;		
				}else
					update_idx=0;
				
				next.update(r, lobby[COLOR],update_idx);
				if(next.visited) continue;
				next.visited=true;
				q.add(lobby[NEXT]);
			}
			
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		lobbies = new ArrayList[N+1];
		rooms = new Room[N+1];
		for(int i=1; i<=N; i++) {
			lobbies[i] = new ArrayList<>();
			rooms[i] = new Room();
		}
		int a,b,c;
		for(int i=0; i<M; i++) {
			st = new  StringTokenizer(br.readLine());
			a = stoi(st.nextToken());
			b=stoi(st.nextToken());
			c=stoi(st.nextToken());
			
			lobbies[a].add(new int[] {b,c});
			lobbies[b].add(new int[] {a,c});
		}
		for(int i=1; i<=N; i++) {
			Collections.sort(lobbies[i],(x,y)->(x[COLOR]-y[COLOR]));
		}
		
		bfs();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.format("%d\n", rooms[N].path.size()));
		
		for(int x: rooms[N].path){
			bw.write(String.format("%d ", x));
		}
		bw.flush();
		bw.close();

	}
}
