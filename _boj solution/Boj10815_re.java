
import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] cards = new int[N];
        for (int i = 0; i < N; i++)
            cards[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int num;
        for (int i = 0; i < M; i++) {
            num = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(cards, num) >= 0)
                sb.append("1 ");
            else
                sb.append("0 ");

        }

        System.out.println(sb.toString());

    }

}
