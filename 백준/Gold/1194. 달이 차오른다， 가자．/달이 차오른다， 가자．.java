import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Deque<State> q = new ArrayDeque<>();
	static char map[];
	static int visited[][];
	static int N, M, sr, sc;
	static int d[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N * M];
		visited = new int[N * M][(2 << 5)];

		for (int r = 0; r < N; r++) {
			String s = br.readLine();
			for (int c = 0; c < M; c++) {
				char cell = s.charAt(c);
				int curr = r * M + c;
				if (cell == '0') {
					sr = r;
					sc = c;
					cell = '.';
				}
				map[curr] = cell;
			}
		}
		
		System.out.println(bfs(sr, sc));
	}
	
	static int bfs(int sr, int sc) {
		q.add(new State(sr, sc, 0));
		for (int i = 0; i < N * M; i++) {
			Arrays.fill(visited[i], -1);
		}
		visited[sr * M + sc][0] = 0;
		
		while(!q.isEmpty()) {
			State currState = q.poll();
			int cr = currState.r;
			int cc = currState.c;
			int ck = currState.key;
			int curr = cr * M + cc;
			
			for (int i = 0; i < 4; i++) {
				int nr = cr + d[i][0];
				int nc = cc + d[i][1];
				if (!isValid(nr, nc)) continue;
				
				int nk = ck;
				int next = nr * M + nc;
				
				char nv = map[next];
				
				if (nv == '#') continue;
				if ('a' <= nv && nv <= 'z') {
					nk |= (1 << (nv - 'a'));
				}
				if ('A' <= nv && nv <= 'Z') {
					if ((ck & (1 << (nv - 'A'))) == 0) {
						continue;
					}
				}
				
				if (nv == '1') {
					return visited[curr][ck] + 1;
				}
				
				if (visited[next][nk] != -1) {
					continue;
				}
				
				visited[next][nk] = visited[curr][ck] + 1;
				q.add(new State(nr, nc, nk));
				
			}
		}
		return -1;
	}

	static boolean isValid(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
}

class State{
	int r;
	int c;
	int key;
	
	public State(int r, int c, int key) {
		super();
		this.r = r;
		this.c = c;
		this.key = key;
	}
}

