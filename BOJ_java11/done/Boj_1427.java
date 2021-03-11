package done;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj_1427 {

//	public static void main(String[] args) {
//		int N;
//		int[] nums = new int[10];
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		StringBuilder sb = new StringBuilder(10);
//		N = sc.nextInt();
//		sc.close();
//		while (N > 0) {
//			nums[N % 10]++;
//			N /= 10;
//		}
//		for (int i = 9; i >= 0; i--) {
//			for (; nums[i] > 0; nums[i]--) {
//				sb.append(i);
//			}
//		}
//		System.out.println(sb.toString());
//
//	}
	
	public static void main(String[] args) throws IOException {
		ArrayList<Character> arr = new ArrayList<>(10);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(10);
		for (char ch : br.readLine().toCharArray()) {
			arr.add(ch);
		}
		Collections.sort(arr,Collections.reverseOrder());
		for (char ch : arr)
			sb.append(ch);
		System.out.print(sb.toString());
		
	}

}
