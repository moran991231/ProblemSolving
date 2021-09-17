import java.io.*;
import java.util.*;

class Boj2251 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int A,B,C;
	static boolean bottles[][][];
	static boolean enabled[];

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static class Status{
		int a, b, c;
		public  Status(int a, int  b,int c) {
			this.a=a;
			this.b=b;
			this.c=c;
		}
	}
	
	static Status pour(int a, int b, int c, int type) { // type 0~5
		int x,y,X,Y,sum;
		if(type<2) {
			x=a;
			X=A;
		}else if (type<4) {
			x=b;
			X=B;
		}else {
			x=c;
			X=C;
		}
		if(type==2||type==4) {
			y=a;
			Y=A;
		}else if (type==0||type==5) {
			y=b;
			Y=B;
		}else {
			y=c;
			Y=C;
		}
		// pour
		sum=x+y;
		x = Math.max(0, sum-Y);
		y = Math.min(Y, sum);
		
		if(type<2) {
			a=x;
		}else if (type<4) {
			b=x;
		}else {
			c=x;
		}
		if(type==2||type==4) {
			a=y;
		}else if (type==0||type==5) {
			b=y;
		}else {
			c=y;
		}
		
		if(bottles[a][b][c])
			return null;
		
		return new Status(a,b,c) ;
	}
	
	public static void bfs() {
		Queue<Status> q = new LinkedList<Status>();
		enabled[C]=true;
		bottles[0][0][C]=true;
		q.add(new Status(0,0,C));
		
		Status now, next;
		int a,b,c;
		while(!q.isEmpty()) {
			now = q.remove();
			a=now.a;
			b=now.b;
			c=now.c;
			for(int i=0; i<6;i++) {
				if((next=pour(a,b,c,i)) !=null	) {
					if(next.a==0) enabled[next.c]=true;
					bottles[next.a][next.b][next.c]=true;
					q.add(next);
				}
			}
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		
		st = new StringTokenizer(br.readLine());
		A =stoi(st.nextToken());
		B = stoi(st.nextToken());
		C = stoi(st.nextToken());
		enabled = new boolean[C+1];
		bottles = new boolean[201][201][201];
		
		bfs();
		
		for(int i=0; i<=C;i++	) {
			if(enabled[i]==true)
				sb.append(i).append(' ');
		}
		System.out.println(sb.toString());
	}
}
