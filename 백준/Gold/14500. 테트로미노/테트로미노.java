import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int map[];
	static boolean visited[];
	static int d[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int N, M, max = 0;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N * M];
		map = new int[N * M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				int curr = r * M + c;
				int cell = Integer.parseInt(st.nextToken());
				map[curr] = cell;
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				int curr = r * M + c;
				visited[curr] = true;
				makeTetromino(r, c, 1, map[curr]);
				visited[curr] = false;
			}
		}

		System.out.println(max);
	}
	
	static void makeTetromino(int r, int c, int depth, int sum) {
		if (depth == 4) {
			if (max < sum) {
				max = sum;
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + d[i][0];
			int nc = c + d[i][1];
			
			if (!isValid(nr, nc)) continue;
			
			int next = nr * M + nc;
			if(visited[next]) continue;
		
			visited[next] = true;
			makeTetromino(nr, nc, depth + 1, sum + map[next]);
			if(depth == 2) {
				makeTetromino(r, c, depth + 1, sum + map[next]);
			}
			visited[next] = false;
		}
	}
	
	static boolean isValid(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
	
}

