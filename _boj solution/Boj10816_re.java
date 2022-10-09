
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] cards = new int[20_000_001];
    static final int OFFSET = 10_000_000;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Arrays.fill(cards, 0);
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            cards[card + OFFSET]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int card = Integer.parseInt(st.nextToken());
            sb.append(cards[card + OFFSET]).append(' ');
        }
        System.out.println(sb.toString());

    }
}