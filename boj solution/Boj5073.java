package round5;

import java.io.*;
import java.util.*;

class Boj5073 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final String EQUIL = "Equilateral\n", ISOS = "Isosceles\n", SCAL = "Scalene\n", INVAL = "Invalid\n";

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);

		int[] tri = new int[3];
		while (true) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++)
				tri[i] = stoi(st.nextToken());
			if (tri[0] == 0 && tri[1] == 0 && tri[2] == 0)
				break;
			Arrays.sort(tri);
			if(tri[0]+tri[1]<=tri[2])
				sb.append(INVAL);
			else if (tri[0]==tri[1]&& tri[1]==tri[2])
				sb.append(EQUIL);
			else if (tri[0]!=tri[1]&&tri[1]!=tri[2])
				sb.append(SCAL);
			else
				sb.append(ISOS);

		}
		System.out.println(sb.toString());
	}

}
