package done;


import java.io.*;
import java.util.*;

class MyDeque {
	boolean direc = true;
	Deque<Integer> dq = new LinkedList<>();
	boolean isErr = false;
	static final String ERR = "error\n";

	
	void calc_functions(String func) {
		for(byte f: func.getBytes()) {
			if(f == 'R') R();
			else if(f == 'D') {
				if(D() == false) break;
			}
		}
	}
	boolean R() {
		direc = !direc;
		return true;
	}

	boolean D() {
		if (dq.isEmpty()) {
			isErr = true;
			return false;
		}
		if (direc) {
			dq.removeFirst();
		} else {
			dq.removeLast();
		}
		return true;
	}
	
	void appendTo(StringBuilder sb) {
		if(isErr) sb.append(ERR);
		
		else if(dq.isEmpty()) sb.append('[').append(']').append('\n');
		else {
			sb.append('[');
			while(true) {
				if(direc) sb.append(dq.removeFirst());
				else sb.append(dq.removeLast());
				if(dq.isEmpty()) break;
				else sb.append(',');				
			}
			sb.append(']').append('\n');
			
		}
		
	}
}

 class Boj_5430 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;


	public static void main(String[] args) throws NumberFormatException, IOException {
		sb.setLength(0);
		int T;
		String func;
		int N;

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			func = br.readLine();

			N = Integer.parseInt(br.readLine());
			
			MyDeque mdq = new MyDeque();
			String temp = br.readLine();
			st = new StringTokenizer(temp.substring(1, temp.length() - 1), ",");
			for (int i = 0; i < N; i++)
				 mdq.dq.add(Integer.parseInt(st.nextToken()));
			
			mdq.calc_functions(func);
			mdq.appendTo(sb);

		}
		System.out.println(sb.toString());

	}
}
