package done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2798 {
	int N,M;
	int[] A=new int[100];
	
	void main_func() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)	);
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++	)
			A[i] = Integer.parseInt(st.nextToken());
		br.close();
		st=null;
		
		int sum=0;
		int max=0;
		
		for(int a=0; a<N; a++) {
			for(int b=a+1; b<N; b++) {
				for(int c=b+1; c<N; c++) {
					sum= A[a]+A[b]+A[c];
					if(max<sum && sum<=M)
						max=sum;
				}
			}
		}
		
		System.out.println(max);
		
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
