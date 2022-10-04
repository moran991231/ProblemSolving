package done;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int compareTo(Point p) {
		if(this.x == p.x) return this.y -p.y;
		else return this.x-p.x;
		
	}
}

public class Boj_11650 {
	ArrayList<Point> arr = new ArrayList<>(100_000);
	StringBuilder sb = new StringBuilder(100_000);
	int N;

	void main_func() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		br.close();
		arr.sort((p1, p2)->p1.compareTo(p2));
		for(Point p : arr) {
			sb.append(p.x).append(' ').append(p.y).append('\n');
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Boj_11650().main_func();

	}

}
