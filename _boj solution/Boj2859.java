package done;

import java.io.*;
import java.util.*;

class Boj2859 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final String[] DAY = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
	static final int MINS_PER_DAY = 24 * 60;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static void twinkle(int t1, int t2, int p1, int p2) {
		if ((p1 == p2) && (Math.abs(t1-t2)%p1!=0)) {
			sb.append("Never");
			return;
		}
		if (p1 > p2) {
			int temp = p1;
			p1 = p2;
			p2 = temp;
			temp = t1;
			t1 = t2;
			t2 = temp;
		}

		int cnt=0;
		while (true) {
			cnt++;
			if(cnt>2000)
				break;
			while (t1 < t2) {
				t1 += p1;
			}
			if (t1 == t2)
				break;
			while (t2 < t1) {
				t2 += p2;
			}
			if (t1 == t2)
				break;
		}
		if(cnt>2000) {
			sb.append("Never");
			return;
		}
		sb.append(DAY[(t1 / MINS_PER_DAY)%7]).append('\n');
		sb.append(String.format("%02d:%02d", (t1 / 60) % 24, t1 % 60));

	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		int t1 = 0, t2 = 0, p1 = 0, p2 = 0;

		st = new StringTokenizer(br.readLine(), ":");
		t1 += (stoi(st.nextToken()) * 60 + stoi(st.nextToken()));

		st = new StringTokenizer(br.readLine(), ":");
		t2 += (stoi(st.nextToken()) * 60 + stoi(st.nextToken()));

		st = new StringTokenizer(br.readLine(), ":");
		p1 += (stoi(st.nextToken()) * 60 + stoi(st.nextToken()));

		st = new StringTokenizer(br.readLine(), ":");
		p2 += (stoi(st.nextToken()) * 60 + stoi(st.nextToken()));

		twinkle(t1, t2, p1, p2);
		System.out.println(sb.toString());

	}
}
