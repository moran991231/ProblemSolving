package adsf;

import java.io.*;
import java.util.*;

class Main__ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N,M;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static class Person implements Comparable<Person>{
		ArrayList<Integer> bells = new ArrayList<>();
		
		public int compareTo(Person p) {
			return -(this.bells.size()-p.bells.size());
		}
	}
	
	public static boolean isContain(ArrayList<Integer>b1, ArrayList<Integer>b2) {
		
		int b2Size = b2.size();
		for(int i=0; i<b2Size; i++) {
			if(b1.get(i) != b2.get(i))
				return false;
		}
		
		return true;
	}
	

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		
		Person[] people = new Person[N];
		for(int i=0; i<N; i++) {
			Person p = new Person();
			people[i] =p;
			st = new  StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int b = stoi(st.nextToken());
				if(b==1)
					p.bells.add(j);
			}
			
		}
		
		Arrays.sort(people);
		
		String ret="YES\n";
		ArrayList<Integer> heard = people[0].bells;
		for(int i=1; i<N; i++) {
			
			if(isContain(heard,people[i].bells)==false) {
				ret = "NO\n";
				break;
			}
//			heard = people[i].bells;
		}
		
		System.out.println(ret);
		
	}

}
