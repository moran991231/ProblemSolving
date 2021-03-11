package done;

import java.io.*;
import java.util.*;

class Boj_2261_recur {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Point> points;

	static class Point implements Comparable<Point> {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Point p) {
			if (x == p.x) return y - p.y;
			return x - p.x;
		}
	}
	
	static class Cmpr_y implements Comparator<Point>{
		public int compare(Point p1, Point p2) {
			return p1.y-p2.y;
		}
	}
	static boolean inRange(int x, int lowL, int highL) {
		if (lowL <= x && x <= highL) return true;
		return false;
	}

	static int distSqr(Point a, Point b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}

	static int closest(int min, int s, int e) {
		if (e <= s + 2) {
			for (int i = s; i < e; i++)
				for (int j = i + 1; j <= e; j++)
					min = Math.min(min, distSqr(points.get(i), points.get(j)));
			return min;
		}
		int mid = (s+e)/2;
		min = closest(min, s, mid);
		min = closest(min, mid+1, e);
		
		ArrayList<Point> cand = new ArrayList<>();
		
		for(int i=mid; s<=i; i--) {
			int d = points.get(mid).x - points.get(i).x;
			if(d*d < min) 
				cand.add(points.get(i));
			else break;
		}
		for(int i=mid+1; i<=e;i++) {
			int d = points.get(i).x-points.get(mid).x;
			if(d*d<min)
				cand.add(points.get(i));
			else break;
		}
		
		cand.sort(new Cmpr_y());
		int m = cand.size();
		for(int i=0; i<m; i++) {
			for(int j=i+1; j<m; j++) {
				int d = cand.get(j).y - cand.get(i).y;
				if(min <= d*d) break;
				else 
					min = Math.min(min,distSqr(cand.get(i), cand.get(j)));
			}
		}
		
		return min;
	}

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int min = 800_000_000;
		points = new ArrayList<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			points.add(new Point(x, y));
		}

		Collections.sort(points);
		
		min = closest(min,0, N-1);
		System.out.println(min);

	}

}
