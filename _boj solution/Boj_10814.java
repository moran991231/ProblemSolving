package done;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10814 {

	public static void main(String[] args) throws IOException{
		int N;
		StringBuilder[] sbarr = new StringBuilder[201];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<201; i++)
			sbarr[i] = new StringBuilder();
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			st = new StringTokenizer(line);
			sbarr[Integer.parseInt(st.nextToken())].append(line).append('\n');
		}
		for(StringBuilder item : sbarr)
			sbarr[0].append(item);
		System.out.println(sbarr[0].toString());
	}

}
