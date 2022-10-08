
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final String BLACK = "0", WHITE = "1";

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static String compressImg(char[][] img, int w, int r, int c) {
        if (w == 1) {
            return img[r][c] == '0' ? BLACK : WHITE;
        }

        w /= 2;
        String[] ret = new String[4];
        ret[0] = compressImg(img, w, r, c);
        ret[1] = compressImg(img, w, r, c + w);
        ret[2] = compressImg(img, w, r + w, c);
        ret[3] = compressImg(img, w, r + w, c + w);

        boolean isSame = true;
        for (int i = 1; i < 4; i++) {
            if (ret[i] != ret[i - 1]) {
                isSame = false;
                break;
            }
        }
        if (isSame) {
            return ret[0];
        } else {
            return String.format("(%s%s%s%s)", ret[0], ret[1], ret[2], ret[3]);
        }

    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        char[][] img = new char[N][];
        for (int i = 0; i < N; i++) {
            img[i] = br.readLine().toCharArray();

        }
        String ret = compressImg(img, N, 0, 0);
        System.out.println(ret);

    }
}