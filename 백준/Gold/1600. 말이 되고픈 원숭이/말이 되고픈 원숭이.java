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
	static Deque <State> q = new ArrayDeque<>();
	static int map[][];
	static int visited[][][];
	static int dm[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int dh[][] = {	{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, 
							{1, -2}, {2, -1}, {2, 1}, {1, 2}};
	static int K, N, M, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());
		State.K = K;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		visited = new int[N][M][K+1];
		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		init();
		bfs(0, 0, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1: min);
	}
	
	static void init() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				Arrays.fill(visited[r][c], -1);
			}
		}
	}
	
	static void bfs(int r, int c, int k) {
		q.add(new State(r, c, k));
		visited[r][c][k] = 0;
		
		while(!q.isEmpty()) {
			State curr = q.poll();
			if (curr.canMoveLikeHorse()) {
				for (int i = 0; i < 8; i++) {
					int nr = curr.r + dh[i][0];
					int nc = curr.c + dh[i][1];
					int nk = curr.k + 1;
					
					if(!isValid(nr, nc)) continue;
					if(map[nr][nc] == 1) continue; 
					if(visited[nr][nc][nk] != -1) continue; 
					visited[nr][nc][nk] = visited[curr.r][curr.c][curr.k] + 1;
					q.add(new State(nr, nc, nk));
				}
			}
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dm[i][0];
				int nc = curr.c + dm[i][1];
				int nk = curr.k;
				
				if(!isValid(nr, nc)) continue;
				if(map[nr][nc] == 1) continue;
				if(visited[nr][nc][nk] != -1) continue; 
				visited[nr][nc][nk] = visited[curr.r][curr.c][curr.k] + 1;
				q.add(new State(nr, nc, nk));
			}
		}
		
		for (int i = 0; i < K + 1; i++) {
			if (visited[N-1][M-1][i] == -1) continue;
			if (visited[N-1][M-1][i] < min) {
				min = visited[N-1][M-1][i];
			}
		}
		
	}
	
	static boolean isValid(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
	
}

class State{
	static int K;
	int r;
	int c;
	int k;
	
	public State(int r, int c, int k) {
		super();
		this.r = r;
		this.c = c;
		this.k = k;
	}
	
	boolean canMoveLikeHorse() {
		return this.k < K;
	}
}
