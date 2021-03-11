package done;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Member implements Comparable<Member>{
	int age;
	String name;
	int order;
	Member (int age, String name,int order){
		this.age = age;
		this.name = name;
		this.order=order;
	}
	
	@Override
	public int compareTo(Member mem) {
		if (this.age == mem.age)
			return this.order-mem.order;
		else
			return this.age-mem.age;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(10);
		sb.append(age).append(' ').append(name).append('\n');
		return sb.toString();
	}
}
public class Boj_10814_ {

	public static void main(String[] args) throws IOException {
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder(1000000);
		N = Integer.parseInt(br.readLine());
		Member[] arr = new Member[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i]= new Member(Integer.parseInt(st.nextToken()), st.nextToken(), i);
		}
		br.close();
		
		Arrays.sort(arr);
		for (Member mem: arr)
			sb.append(mem.toString());
		System.out.println(sb.toString());

	}

}
