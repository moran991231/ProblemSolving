package done;

import java.io.*;
import java.util.*;

class Boj_14003 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static int N;
	static int[] A, A_lis;
	static ArrayList<Integer> len;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int addTolen(int target) {
		int size = len.size();
		if (size == 0) {
			len.add(target);
			return 0;
		}
		if (len.get(size - 1) < target) {
			len.add(target);
			return size ;
		}

		int s = 0, e = size - 1, p = 0, lenp;
		while (s <= e) {
			p = (s + e) / 2;
			lenp = len.get(p);
			if (lenp == target) {
				return p ;
			} else if (target < lenp) {
				if (e == p) {
					len.set(p, target);
					return p ;
				}
				e = p;
			} else s = p + 1;
		}

		return p ;

	}

	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		A_lis = new int[N];
		len = new ArrayList<>();
		for (int i = 0; i < N; i++) A[i] = stoi(st.nextToken());

		for (int i = 0; i < N; i++)
			A_lis[i] = addTolen(A[i]);

		int leni = len.size()-1, Ai;
		StringBuilder sb = new StringBuilder();
		sb.append(leni+1).append('\n');
		
		for(Ai = N-1; 0<=Ai; Ai--) 
			if(A_lis[Ai] == leni)
				break;
		
		for(--Ai, --leni; 0<=leni; Ai-- ) {
			if(A[Ai]<len.get(leni+1) && A_lis[Ai] == leni) {
				len.set(leni, A[Ai]);
				leni--;
			}
		}
		
		
		for(int x: len)
			sb.append(x).append(' ');
		System.out.println(sb.toString());
	}

}
