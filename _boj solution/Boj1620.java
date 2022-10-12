
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), M = stoi(st.nextToken());
        String[] pokedex = new String[N + 1];
        Map<String, Integer> pokemap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            pokedex[i] = br.readLine();
            pokemap.put(pokedex[i], i);
        }

        StringBuilder sb = new StringBuilder(M * 20);
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if ('1' <= s.charAt(0) && s.charAt(0) <= '9') {
                int num = stoi(s);
                sb.append(pokedex[num]).append('\n');
            } else {
                sb.append(pokemap.get(s)).append('\n');
            }
        }
        System.out.println(sb.toString());

    }
}