package done;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Boj_1181 {

	public static void main(String[] args)throws IOException {
		int N;
		ArrayList<String> arr ;
		HashSet<String> set = new HashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++)
			set.add(br.readLine());
		br.close();
		arr = new ArrayList<>(set);
//		Collections.sort(arr,(String s1, String s2)-> (s1.length()==s2.length())? s1.compareTo(s2): s1.length()-s2.length());
		arr.sort(new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) 
					return s1.compareTo(s2);
				else return s1.length()-s2.length();
			}
		});
		StringBuilder ret = new StringBuilder(200000);
		for(String s: arr)
			ret.append(s).append('\n');
		
		System.out.println(ret.toString());
	}

}
