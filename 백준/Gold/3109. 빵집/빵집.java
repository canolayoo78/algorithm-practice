import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int R;
	static int C;
	static boolean[][] map;
	static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
	
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		
		for (int r = 0; r < R; r++) {
			String input = br.readLine().trim();
			for (int c = 0; c < C; c++) {
				if (input.charAt(c) == '.') {
					map[r][c] = true;
				}
			}
		}
		
        int ans = 0;
		for (int r = 0; r < R; r++) {
			if (dfs(r, 0)) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	static boolean isValid(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
	
	static boolean dfs(int r, int c) {
		if (c == C-1) {
			return true;
		}
		
		for (int d = 0; d < 3; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			
			if (!isValid(nr,nc)) continue;
			if (!map[nr][nc]) continue;
			
			map[nr][nc] = false;
			if (dfs(nr, nc)) return true;
		}
		return false;
	}
}
