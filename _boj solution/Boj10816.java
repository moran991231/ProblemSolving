
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int countCards(int[] cards, int target) {
        int N = cards.length;
        int leftBound, rightBound;

        // find leftbound
        int l = 0, r = N - 1, p = (l + r) / 2;
        while (l < r) {
            p = (l + r) / 2;
            if (cards[p] < target) {
                l = p + 1;

            } else if (target < cards[p]) {
                r = p - 1;
            } else {
                r = p;
            }
        }
        // System.out.println("l: " + r);
        if (r < 0)
            return 0;
        else if (cards[r] == target)
            leftBound = r;
        else
            return 0;

        // find right bound
        l = 0;
        r = N - 1;

        while (l < r) {
            p = (l + r + 1) / 2;
            if (cards[p] < target) {
                l = p + 1;
            } else if (target < cards[p]) {
                r = p - 1;
            } else {
                l = p;
            }
        }
        // System.out.println("r: " + l);
        rightBound = l;

        return rightBound - leftBound + 1;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            sb.append(countCards(cards, Integer.parseInt(st.nextToken()))).append(' ');

        System.out.println(sb.toString());

    }
}