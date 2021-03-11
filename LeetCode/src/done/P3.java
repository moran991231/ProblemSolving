package done;


class P3 {
    public int lengthOfLongestSubstring(String s) {
        int []exist = new int[128]; 
        int max=0;  // value to return
        int pl=0,pr=0; //start,end indices of sub-string
        
        int s_len=s.length();
        int len;
        char ch;
        
        while(pr<s_len) { // pr increases from 0 to s_len
        	ch= s.charAt(pr);
        	if(exist[ch]<=pl) { // ch dosesn't exist in sub_s
        		exist[ch]=++pr;
        	}else { // ch exists in sub_s
        		len = pr-pl;
        		max = (max>len)?max:len;
        		pl=exist[ch];
        		exist[ch]=++pr;
        	}
        }
        len = pr-pl; //calculate sub_s length which is located at the end of s
        max=(max>len)?max:len;
        return max;    	
    }
}