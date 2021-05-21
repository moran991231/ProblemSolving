package done;

import java.io.*;
import java.util.*;

class Boj9241 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		Deque<Character> orig = new LinkedList<>(),modified = new LinkedList<>();
		char[] str = br.readLine().toCharArray();
		for(char ch:str)
			orig.add(ch);
		 str = br.readLine().toCharArray();
		for(char ch:str)
			modified.add(ch);
		int len= Math.min(orig.size(), modified.size());
		for(int i=0; i<len;i++) {
			if(orig.getFirst()!=modified.getFirst())break;
			orig.removeFirst();
			modified.removeFirst();
		}
		
		 len= Math.min(orig.size(), modified.size());
		for(int i=0; i<len;i++) {
			if(orig.getLast()!=modified.getLast())break;
			orig.removeLast();
			modified.removeLast();
		}
		
		System.out.println(modified.size());
		

	}
}
