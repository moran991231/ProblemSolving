package done;

import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj_10815 {

	static int binary_search(ArrayList<Integer> arr, int num) {
		int start = 0, end = arr.size() - 1;
		int idx = (start + end) / 2;
		int arr_i;
		while (start <= end) {
			arr_i = arr.get(idx);
			if (num == arr_i)
				return 1;
			else if (num < arr_i)
				end = idx - 1;
			else
				start = idx + 1;
			idx = (start + end) / 2;
		}
		return 0;

	}

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> arr1 = new ArrayList<>(500_000);
//		ArrayList<Integer> arr2 = new ArrayList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(4500000);

//		int N = Integer.parseInt(br.readLine());
		br.readLine();
		for (String s : br.readLine().split(" "))
			arr1.add(Integer.parseInt(s));

		Collections.sort(arr1);

//		int M = Integer.parseInt(br.readLine());
		br.readLine();
		for (String s : br.readLine().split(" "))
			sb.append(binary_search(arr1, Integer.parseInt(s))).append(' ');
		br.close();

		System.out.println(sb.toString());

	}

}
