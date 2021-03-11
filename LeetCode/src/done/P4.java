package done;

class P4 {
	final int NegInf = Integer.MIN_VALUE;
	final int PosInf = Integer.MAX_VALUE;
	boolean inRange(int val, int lLim, int hLim) {
		if (lLim <= val && val < hLim)
			return true;
		else
			return false;
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length+nums2.length;
		int half = len/2;
		int s1,e1,p1,p2;
		int a,b;
		int l1,l2,r1,r2;
		if(nums1.length >nums2.length) {
			int[] temp;
			temp = nums1;
			nums1=nums2;
			nums2=temp;
		}
		a=nums1.length;
		b=nums2.length;
		s1=0;
		e1 = a-1;
		while(true) {
			if(e1<s1) s1=e1-1;
			p1 = (s1+e1)/2;
			p2 = half-(p1+1)-1;
			
			l1 = 0<=p1? nums1[p1]: NegInf;
			r1 = p1+1 <a? nums1[p1+1]:PosInf;
			l2 = inRange(p2,0,b)? nums2[p2]:NegInf;
			r2 = inRange(p2+1,0,b)? nums2[p2+1]:PosInf;
			
			if(l1<=r2 && l2<=r1) {
				if(len%2==1) return Math.min(r1,r2);
				else return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
			}else if (l1>r2) {
				e1=p1-1;
			}else  {
				s1=p1+1;
			}
		}
		
	}
}