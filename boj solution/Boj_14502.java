package done;

import java.util.Scanner;
//import java.util.Random;

public class Boj_14502 {
	int N, M;
	int[] A = new int[100_000];

	void my_sort(int[] arr, int start, int end) {
		if (start>= end)
			return;
		int pivot = arr[start];
		int left = start , right = end;	
		int temp;
		
		while(left<right) {
			while(pivot<arr[right]) right--;
			
			while(left<right && arr[left]<=pivot)left++;
			
			temp=arr[left];
			arr[left]=arr[right];
			arr[right]=temp;
		}
		arr[start]=arr[left];
		arr[left]=pivot;
		
		my_sort(arr,start,left-1);
		my_sort(arr,left+1,end);

	}

	int binary_search(int[] arr, int len, int num) {
		int start = 0, end = len - 1;
		int cursor = (start + end) / 2;

		while (start <= end) {
			if (num == arr[cursor])
				return 1;
			else if (num < arr[cursor]) {
				end = cursor - 1;
			} else {
				start = cursor + 1;
			}
			cursor = (start + end) / 2;
		}
		return 0;
	}

	void main_func() {
		Scanner sc = new Scanner(System.in);
//		Random r = new Random();
		N = sc.nextInt();
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		my_sort(A, 0, N - 1);

		M = sc.nextInt();

		int num, ret;
		for (int i = 0; i < M; i++) {
			num = sc.nextInt();
			ret = binary_search(A, N, num);
			System.out.println(ret);
		}
		sc.close();
	}

	public static void main(String[] args) {
		new Boj_14502().main_func();
	}

}
