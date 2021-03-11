package done;


import java.io.*;
import java.util.StringTokenizer;

public class Boj_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		String str = br.readLine();
		int idx = str.indexOf('-');
		if (idx > 0) {
			st = new StringTokenizer(str.substring(0, idx), "+-");
			while (st.hasMoreTokens())
				sum += Integer.parseInt(st.nextToken());
			st = new StringTokenizer(str.substring(idx + 1), "+-");
			while (st.hasMoreTokens())
				sum -= Integer.parseInt(st.nextToken());
		} else {
			st = new StringTokenizer(str, "+-");
			while (st.hasMoreTokens())
				sum += Integer.parseInt(st.nextToken());
		}

		System.out.print(sum);

	}

}
