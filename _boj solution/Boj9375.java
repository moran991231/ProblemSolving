
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        int T = stoi(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = stoi(br.readLine());
            HashMap<String, Integer> closet = new HashMap<>(30);
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken(), kind = st.nextToken();
                if (closet.containsKey(kind)) {
                    closet.put(kind, closet.get(kind) + 1);
                } else {
                    closet.put(kind, 1);
                }
            }

            int num_case = 1;
            for (Map.Entry<String, Integer> x : closet.entrySet()) {
                num_case *= x.getValue() + 1;
            }
            System.out.println(num_case - 1);
        }

    }
}