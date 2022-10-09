
import java.io.*;
import java.util.*;

class Main {
    static class Meeting implements Comparable<Meeting> {
        int start, end;

        Meeting() {
        }

        Meeting(int s, int e) {
            start = s;
            end = e;
        }

        public int compareTo(Meeting m) {
            if (end == m.end)
                return start - m.start;
            return end - m.end;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());

        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(stoi(st.nextToken()), stoi(st.nextToken()));
        }
        Arrays.sort(meetings);

        int cnt = 0, last_end = -1;
        for (Meeting m : meetings) {
            if (m.start < last_end) {
                continue;
            }
            cnt++;
            last_end = m.end;
        }
        System.out.println(cnt);

    }
}