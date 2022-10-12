
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
        Set<String> notHeard = new HashSet<>(N);
        Set<String> notSeen = new HashSet<>(M);
        for (int i = 0; i < N; i++) {
            notHeard.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            notSeen.add(br.readLine());
        }

        notHeard.retainAll(notSeen);
        sb.append(notHeard.size()).append('\n');
        ArrayList<String> ret = new ArrayList<>(notHeard);
        Collections.sort(ret);
        for (String s : ret)
            sb.append(s).append('\n');
        System.out.println(sb.toString());

    }
}