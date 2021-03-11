package done;

import java.io.*;
import java.util.*;


class Boj_2261 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

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

	static boolean inRange(int x, int lowL, int highL) {
		if (lowL <= x && x <= highL) return true;
		return false;
	}

	static int distSqr(Point a, Point b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int min = 800_000_000;
		int d = (int) Math.sqrt(min) + 1;
		TreeMap<Integer, ArrayList<Integer>> points = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			if (!points.keySet().contains(x))
				points.put(x, new ArrayList<>());

			points.get(x).add(y);
		}

		for (int x : points.keySet())
			Collections.sort(points.get(x));

		ArrayList<Integer> keys = new ArrayList<Integer>(points.keySet());
		ArrayList<Point> cand = new ArrayList<>();
		
		int x,y;
		x = keys.get(0);
		y = points.get(x).get(0);
		points.get(x).remove(0);
		if (points.get(x).isEmpty()) {
			points.remove(x);
			keys.remove(0);
		}
		cand.add(new Point(x,y));
		
		x = keys.get(0);
		y = points.get(x).get(0);
		points.get(x).remove(0);
		if (points.get(x).isEmpty()) {
			points.remove(x);
			keys.remove(0);
		}
		cand.add(new Point(x,y));
		
		min = distSqr(cand.get(0),cand.get(1));
		d = (int)Math.sqrt(min)+1;
		
		for(int i=0; i<keys.size(); i++) {
			int x1 = keys.get(i);
			for(int y1: points.get(x1)) {
				Point now = new Point(x1,y1);
				for(int c=0;c<cand.size();) {
					Point pc = cand.get(c);
					if(pc.x <= x1-d) {
						cand.remove(c);
					}else if(y1+d<=pc.y) {
						break;
					}else {
						int temp = distSqr(now,pc);
						if(temp<min) {
							min = temp;
							d = (int)Math.sqrt(min)+1;
						}
						c++;
					}
				}
				if(min==0) break;
				cand.add(now);
			}
			if(min==0)break;
		}
		System.out.print(min);

	}

}
