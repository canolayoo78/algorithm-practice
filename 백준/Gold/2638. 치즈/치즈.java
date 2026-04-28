import java.util.Deque;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean isCheese[][];
    static boolean visited[][];
    static byte touched[][];
    static int R, C;
    static int d[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; 

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        isCheese = new boolean[R][C];
        visited = new boolean[R][C];
        touched = new byte[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                isCheese[r][c] = st.nextToken().equals("1");
            }
        }

        Deque<State> q = new ArrayDeque<>(); 

        for (int r = 0; r < R; r++) {
            q.add(new State(r, 0, 0));
            q.add(new State(r, C-1, 0));
        }

        for (int c = 1; c < C - 1; c++) {
            q.add(new State(0, c, 0));
            q.add(new State(R-1, c, 0));
        }

        int ans = 0;

        while(!q.isEmpty()) {
            State cur = q.poll();
            if (visited[cur.r][cur.c])
                continue;
            visited[cur.r][cur.c] = true; 
            ans = cur.time;

            for (int k = 0; k < 4; k++) {
                int nr = cur.r + d[k][0];
                int nc = cur.c + d[k][1];

                if (isNotValid(nr, nc)) continue; 
                if (visited[nr][nc]) continue;

                if(isCheese[nr][nc]) {
                    if (++ touched[nr][nc] >= 2) q.addLast(new State(nr, nc, cur.time + 1));
                }
                else { 
                    q.addFirst(new State(nr, nc, cur.time));
                }
            }
        }

        System.out.println(ans);
    }


    static boolean isNotValid(int r, int c) {
        return !(0 <= r && r < R && 0 <= c && c < C);
        }
    }

class State{
    int r, c, time;
    State(int r, int c, int time){
        this.r = r;
        this.c = c;
        this.time = time;
    }
}