import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R,C;
	static final int WALL =Integer.MAX_VALUE, EMPTY=0,FIRE =Integer.MIN_VALUE;
	static final int[] dr = {0,0,1,-1},dc = {1,-1,0,0};
	static Queue<int[]> qFire = new LinkedList<>(), qJH = new LinkedList<>();
	static int[][] map;
	

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static boolean notInRange(int r, int c) {
		if(0<=r && r<R && 0<=c && c<C) return false;
		return true;
	}
	
	public static int escaping() {
		int size,r,c, rr, cc, path;
		int[] point;
		while(!qJH.isEmpty()) {
			size = qFire.size();
			for(int k=0; k<size; k++) {
				point = qFire.remove();
				r = point[0];
				c=point[1];
				for(int i=0; i<4; i++) {
					rr = r+dr[i];
					cc = c+dc[i];
					if(notInRange(rr, cc)) continue;
					if(map[rr][cc] == WALL || map[rr][cc] == FIRE) continue;
					map[rr][cc]=FIRE;
					qFire.add(new int[] {rr,cc});
				}
			}
			
			size = qJH.size();
			for(int k=0; k<size;k++) {
				point = qJH.remove();
				r = point[0];
				c = point[1];
				path = point[2]+1;
				for(int i=0; i<4; i++) {
					rr = r+dr[i];
					cc = c+dc[i];
					if(notInRange(rr,cc)) return path-1;
					if(map[rr][cc]!=EMPTY) continue;
					map[rr][cc] = path;
					qJH.add(new int[] {rr,cc,path});
					
				}
			}
		}
		return FIRE;
	}

	public static void main(String[] args) throws IOException {
		qFire.clear();
		qJH.clear();
		
		st = new StringTokenizer(br.readLine());
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		map = new int[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C;j++) {
				switch(str.charAt(j)) {
				case '#':
					map[i][j]=WALL;
					break;
				case 'J':
					map[i][j]=1;
					qJH.add(new int[] {i,j,1});
					break;
				case 'F':
					map[i][j]=FIRE;
					qFire.add(new int[] {i,j});
					break;
				}
			}
		}
		int ret = escaping();
		System.out.println(ret==FIRE? "IMPOSSIBLE":ret);
		

	}
}
