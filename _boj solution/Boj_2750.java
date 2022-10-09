package done;

import java.util.Scanner;

public class Boj_2750 {
	int N;
	int[] arr = new int[1000];
	int[] ret = new int[1000];

	void merge_sort(int[] arr, int[] ret, int start, int end) {
		if (start >= end)
			return;

		int mid = (start + end) / 2;

		merge_sort(arr, ret, start, mid);
		merge_sort(arr, ret, mid + 1, end);
		merge(arr, ret, start, end);

	}

	void merge(int[] arr, int[] ret, int start, int end) {
		int i = start, mid = (start + end) / 2, j = (start + end) / 2+1;
		int cursor = start;

		while (i <= mid && j <= end) {
			if (arr[i] < arr[j])
				ret[cursor++] = arr[i++];
			else
				ret[cursor++] = arr[j++];
		}
		int temp = (i>mid)? j:i;		
		while(cursor<=end)
			ret[cursor++]=arr[temp++];
		
		for( temp=start; temp<=end;temp++)
			arr[temp]=ret[temp];
		

	}

	void main_func() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		merge_sort(arr, ret, 0, N - 1);

		for (int i = 0; i < N; i++)
			System.out.println(arr[i]);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Boj_2750().main_func();

	}

}
