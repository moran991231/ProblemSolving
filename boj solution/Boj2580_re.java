
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map = new int[9][9];
    static boolean[][] garo, sero;
    static boolean[][][] square;
    static int[][] blank = new int[81][];

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static boolean available(int r, int c, int n) {
        return (!garo[r][n]) && (!sero[c][n]) && (!square[r / 3][c / 3][n]);
    }

    public static void putNum(int r, int c, int n, boolean fill) {
        map[r][c] = fill ? n : 0;
        garo[r][n] = fill;
        sero[c][n] = fill;
        square[r / 3][c / 3][n] = fill;
    }

    public static boolean sudoku(int dep, int num_blank) {
        if (dep == num_blank) {
            return true;
        }

        int r = blank[dep][0], c = blank[dep][1];
        boolean ret;
        for (int i = 1; i <= 9; i++) {
            if (available(r, c, i)) {
                putNum(r, c, i, true);
                ret = sudoku(dep + 1, num_blank);
                if (ret)
                    return true;
                putNum(r, c, i, false);
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        garo = new boolean[9][10];
        sero = new boolean[9][10];
        square = new boolean[3][3][10];
        int num_blank = 0;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = stoi(st.nextToken());
                if (map[i][j] == 0) {
                    blank[num_blank++] = new int[] { i, j };
                    continue;
                }
                garo[i][map[i][j]] = true;
                sero[j][map[i][j]] = true;
                square[i / 3][j / 3][map[i][j]] = true;
            }
        }

        sudoku(0, num_blank);
        StringBuilder sb = new StringBuilder(900);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());

    }
}