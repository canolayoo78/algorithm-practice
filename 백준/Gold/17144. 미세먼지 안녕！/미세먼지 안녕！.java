import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int R, C, T;
    static int cir1, cir2;
    static Deque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < R; i++) {
            if (map[i][0] == -1) {
                cir1 = i;
                cir2 = i + 1;
                break;
            }
        }


        while(T-- > 0) {
            oneSecondAfter();
        }

        System.out.println(sumOfAll());
    }

    static void oneSecondAfter() {
        spread();
        circulate(true);
        circulate(false);
    }

    static void spread() {
        int[][] d = {{0, 1},{1, 0},{0, -1},{-1, 0}};

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 0 || map[r][c] == -1) continue;
                dq.add(new int[] {r, c, map[r][c]});
            }
        }

        while(!dq.isEmpty()) {

            int[] now = dq.pop();
            int r = now[0];
            int c = now[1];
            int dustNow = now[2];
            int spreadCnt = 0;

            for (int i = 0; i < 4; i++) {
                int nr = r + d[i][0];
                int nc = c + d[i][1];

                if (isValid(nr, nc)) {
                    spreadCnt++;
                    map[nr][nc] += dustNow/5;
                }
            }

            map[r][c] -= spreadCnt * (dustNow/5);
        }
    }

    static boolean isValid(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C && map[r][c] != -1;
    }

    static void circulate(boolean up){
        int[][] d;
        int h, r;
        int c = 0;
        int w = C;
        int dir = 0;

        if (up) {
            d = new int[][]{{0, 1}, {-1, 0}, {0, -1},{1, 0}};
            h = cir1 + 1;
            r = cir1;
        }
        else {
            d = new int[][]{{0, 1},{1, 0},{0, -1},{-1, 0}};
            h = R - cir2;
            r = cir2;
        }

        int prev = 0;
        int now;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < w - 1; j++) {
                int nr = r + d[dir][0];
                int nc = c + d[dir][1];
                now = map[nr][nc];
                map[nr][nc] = prev;

                r = nr;
                c = nc;
                prev = now;
            }
            dir++;
            for (int j = 0; j < h - 1; j++) {
                int nr = r + d[dir][0];
                int nc = c + d[dir][1];
                now = map[nr][nc];
                map[nr][nc] = prev;

                r = nr;
                c = nc;
                prev = now;
            }
            dir++;
        }
        map[cir1][0] = -1;
        map[cir2][0] = -1;
    }

    static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static int sumOfAll(){
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += map[i][j];
            }
        }
        return sum + 2;
    }
}
