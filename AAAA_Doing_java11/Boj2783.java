import java.io.*;
import java.util.*;

class Boj2783 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static double stod(String s) {
		return Double.parseDouble(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		double price, gram;
		st = new StringTokenizer(br.readLine());
		price = stod(st.nextToken());
		gram = stod(st.nextToken());
		double	 min = price/gram;
		int N = stoi(br.readLine()	);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			price = stod(st.nextToken());
			gram = stod(st.nextToken());
			min = Math.min(min, price/gram);
		}
		
		System.out.printf("%.2f\n", min*1000);

	}
}
