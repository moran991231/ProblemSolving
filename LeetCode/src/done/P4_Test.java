package done;

public class P4_Test {
	static public int search(int[] arr, int s1, int e1, int val) {
		int idx = (s1 + e1) / 2;
		if (arr[e1] <= val)
			return e1 + 1;
		if (val < arr[s1])
			return s1 - 1;
		while (s1 <= e1) {
			if (arr[idx] <= val && val <= arr[idx + 1])
				break;
			idx = (s1 + e1) / 2;
			if (val < arr[idx]) {
				e1 = idx - 1;
			} else if (arr[idx] < val) {
				s1 = idx + 1;
			} else
				s1 = idx + 1;

		}
		return idx;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] nums2= {1,3,5,7,9,11,13};
//		int [] nums1= {0,2,4,6,8,10,12};
		int[] nums1 = {1,2,3,4,5};
		int[] nums2 = {0};
//
		P4 s = new P4();
		double ret = s.findMedianSortedArrays(nums1, nums2);
		System.out.println(ret);
//		
//		System.out.println(Test.search(nums2, 1, nums2.length-1,3));

	}

}
