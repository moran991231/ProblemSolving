package done;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj_2108 {
	
	int N;
	int avg=0,median=0,mode=0,min=4001,max=-4001;
	int[] count = new int [8001];
	ArrayList<Integer> nums = new ArrayList<Integer>(500000);
	int count_max=0;
	ArrayList<Integer> mode_list = new ArrayList<>();
	void main_func() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int num;
		for(int i=0; i<N; i++) {
			num = Integer.parseInt(br.readLine());
			nums.add(num);
			avg += num;
			count[num+4000] ++;
			if(num<min) min=num;
			if(max<num) max=num;
		}
		
		br.close();
		Collections.sort(nums);
		avg =Math.round((float)avg/N);
		median=nums.get(N/2);
		nums=null;
		for(int i=0; i<8001;i++	) {
			if(count_max<count[i]) count_max = count[i];
		}
		for(int i=0; i<8001;i++) {
			if(count[i]==count_max)mode_list.add(i-4000);
		}
		System.out.println(avg);
		System.out.println(median);
		System.out.println((mode_list.size()>=2)? mode_list.get(1): mode_list.get(0));
		System.out.println(max-min);
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Boj_2108().main_func();
	}

}
