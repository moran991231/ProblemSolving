package done;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_11651 {
	
	public static void main  (String[] args)throws IOException {
		int N;
		ArrayList<int[]> arr = new ArrayList<>(100_000);
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringBuilder ret = new StringBuilder(1000000);
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int [] p = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			arr.add(p);			
		}
		br.close();
		
		arr.sort((a,b)->(a[1]==b[1]? a[0]-b[0] : a[1]-b[1]));
		
		for (int i=0; i<N; i++)
			ret.append(arr.get(i)[0]).append(' ').append(arr.get(i)[1]).append('\n');
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(ret.toString());
		bw.flush();
		bw.close();
		
	}

}
