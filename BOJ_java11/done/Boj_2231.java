package done;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2231 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		int generator, digit;
		int temp = N;
		for (digit = 1; digit <= 7; digit++) {
			temp /= 10;
			if (temp == 0)
				break;
		}

		temp = N - 9 * digit;
		generator = (temp > 0) ? temp : 0;

		int sum = 0;
		for (; generator <= N; generator++) {
			sum = temp = generator;
			for (; temp != 0; temp /= 10) {
				sum += temp % 10;
			}
			if (sum == N) {
				System.out.print(generator);
				return;
			}

		}
		System.out.print(0);

	}

}
