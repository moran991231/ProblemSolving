package done;

public class P23_Test {
	
	static ListNode makeList(int[] nums) {
		if (nums.length==0) return null;
		ListNode head=null,temp;
		for(int i=nums.length-1; i>=0; i--) {
			temp = new ListNode(nums[i], head);
			head = temp;
		}
		
		temp =head;
				
		return temp;
		
		
	}
	
	static void printList(ListNode head) {
		while(head != null) {
			System.out.printf("%d ", head.val);
			head = head.next;
		}
	}

	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		lists[0] = makeList(new int[]{1,4,5});
		lists[1] = makeList(new int[]{1,3,4});
		lists[2] = makeList(new int[]{2,6});
		
		ListNode ret = P23.mergeKLists(lists);
		printList(ret);
	}

}
