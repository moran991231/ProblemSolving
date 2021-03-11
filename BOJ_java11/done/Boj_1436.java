package done;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1436 {
	int N;

	int contains666(int num) {
		while (num != 0) {
			if (num % 1000 == 666)
				return 1;
			num /= 10;
		}
		return 0;
	}

	void main_func() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();

		int num = 665, i = 0;
		while (i < N) {
			i += contains666(++num);
		}
		System.out.print(num);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Boj_1436().main_func();

	}

}
