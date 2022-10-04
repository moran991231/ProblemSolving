package done;


import java.util.Scanner;

public class Boj_7568 {
	int N;
	int []weight=new int[50];
	int []height=new int[50];
	int []rank = new int[50];
	
	int wi, hi;
	void calc_rank() {
		for(int i=0; i<N; i++) {
			wi=weight[i];
			hi=height[i];
			for(int j=i+1; j<N; j++) {
				if(wi>weight[j] && hi>height[j])
					rank[j]++;
				else if (wi<weight[j]&&hi<height[j])
					rank[i]++;
			}
			System.out.printf("%d ",rank[i]);
		}
		
	}
	
	
	void main_func() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			weight[i]=sc.nextInt();
			height[i]=sc.nextInt();
			rank[i]=1;
		}
		sc.close();
		
		calc_rank();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Boj_7568().main_func();
	}

}
