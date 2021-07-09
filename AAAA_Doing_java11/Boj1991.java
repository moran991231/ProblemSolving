import java.io.*;
import java.util.*;

class Boj1991 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static final char BLANK = '.';
	static char[][] tree;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static void preorder(char root) {
		if(root == BLANK) return;
		sb.append(root);
		preorder(tree[root-'A'][0]);
		preorder(tree[root-'A'][1]);
	}
	static void inorder(char root) {
		if(root == BLANK) return;
		inorder(tree[root-'A'][0]);
		sb.append(root);
		inorder(tree[root-'A'][1]);
	}
	static void postorder(char root) {
		if(root == BLANK) return;
		postorder(tree[root-'A'][0]);
		postorder(tree[root-'A'][1]);
		sb.append(root);
		
	}
	

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		N =stoi(br.readLine());
		tree = new char[26][2];
		char p;
		String str;
		for(int i=0; i<N; i++) {
			str = br.readLine();
			p = str.charAt(0);
			tree[p-'A'][0]=str.charAt(2);
			tree[p-'A'][1]=str.charAt(4);
		}
		
		preorder('A');
		sb.append('\n');
		inorder('A');
		sb.append('\n');
		postorder('A');
		System.out.println(sb.toString());

	}
}
