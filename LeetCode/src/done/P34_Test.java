package done;

import java.util.Arrays;
import java.util.Random;

public class P34_Test {

	public static void main(String[] args) {
		Random rand = new Random();
		
		int len = rand.nextInt(30);
		int[] nums = new int[len];
		int target = rand.nextInt(11);
		for(int i=0; i<len; i++)
			nums[i] = rand.nextInt(11);
		Arrays.sort(nums);
		
		int[] ret = P34.searchRange(nums, target);
		System.out.print(ret[0]+" "+ret[1]);
		
		
		
		
	}

}
