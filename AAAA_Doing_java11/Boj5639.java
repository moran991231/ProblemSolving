import java.io.*;
import java.util.*;

class Boj5639 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class BST{
		Node root=null;
		static class Node{
			int val;
			Node left, right;
			Node(int v){
				val=v;
			}
			public int compareTo(Node n) {
				return val-n.val;
			}
			
			
		}
		void add(Node n){
			if(root==null) {
				root=n;
				return;
			}
			Node cur=root, parent=null;
			while(cur !=null) {
				parent=cur;
				if(n.compareTo(cur)<0) { // n<cur
					cur=cur.left;
				}else {
					cur=cur.right;
				}
			}
			if(n.compareTo(parent)<0)
				parent.left=n;
			else
				parent.right=n;
		}
		
		void postorder(Node root, StringBuilder sb) {
			if(root==null) return;
			postorder(root.left,sb);
			postorder(root.right,sb);
			sb.append(root.val).append('\n');
		}
		
		
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		BST bst = new BST();
		String line;
		while(true) {
			line = br.readLine();
			if(line==null) break;
			if(line.length()==0)break;
			bst.add(new BST.Node(stoi(line)));
		}
		bst.postorder(bst.root, sb);
		System.out.println(sb.toString());

	}
}
