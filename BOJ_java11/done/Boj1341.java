package done;


import java.io.*;
import java.util.*;


class Boj1341 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[] mask=null;

	static long stol(String s) {
		return Long.parseLong(s);
	}
	static void makeMask() {
		mask = new long[63];
		mask[0]=1;
		for(int i=1;i<63;i++) {
			mask[i] = (mask[i-1]<<1)+1;
		}
	}
	
	static long makeABProper(long b) {
		long ret=-1;
		for(long m:mask)
			if(m==b) return 1;
		for(long m:mask) {
			if(m%b==0)
				return m/b;
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		if(mask==null)
			makeMask();
		st = new StringTokenizer(br.readLine());
		long a = stol(st.nextToken()), b= stol(st.nextToken());
		long mul = makeABProper(b);
		if(mul>=1) {
			a*=mul;
			b *=mul;
			
			int len=0;
			char[] pat=new char[63];
			for(int i=0;i<63;i++) {
				if((b&1L)==0L)break;
				len++;
				long x = a&1L;
				pat[62-i]=(x==1)?'*':'-';
				a>>=1;
			b>>=1;
			}
			if(len>60) {
				System.out.println(-1);
			}else {
				for(char ch:pat)
					if(ch!=0)
						sb.append(ch);
				System.out.println(sb.toString());			
			}
		}
		else {
			System.out.println(-1);
		}
		
		
	}
}
