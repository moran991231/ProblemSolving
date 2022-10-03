package done;


import java.util.*;
import java.io.*;

public class Boj_10773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		int num = 0, size = 0;
		for (int i = 0; i < K; i++) {
			num = Integer.parseInt(br.readLine());
			if (num == 0) {
				s.pop();
				size = Math.max(0, size - 1);
			} else {
				s.push(num);
				size++;
			}
		}
		long sum = 0;
		for (sum = 0; 0 < size; size--)
			sum += s.pop();
		System.out.print(sum);

	}

}
