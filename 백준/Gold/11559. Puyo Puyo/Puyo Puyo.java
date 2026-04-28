import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Deque<Integer> q = new ArrayDeque<>();
	static List<Integer> samePuyo = new ArrayList<>();
	static final int R = 12, C = 6 , PUYO = 4;
	static char map[][] = new char[R][C];
	static boolean visited[][] = new boolean[R][C];
	static int d[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	static boolean popExist = false;
	
	public static void main(String[] args) throws IOException {
		for (int r = 0; r < R; r++) {
			String s = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);		
			}
		}
		
		int ans = 0;
		while(true) {
			popExist = false;
			puyopuyo();
			if (!popExist) break;
			ans++;
		}
		System.out.println(ans);
	}
	
	static void puyopuyo() {
		for (int r = 0; r < R; r++) {
			Arrays.fill(visited[r], false);
		}
		for (int r = R-1; 0 <= r; r--) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == '.') continue;
				if (visited[r][c]) continue;
				pop(r, c);
			}
		}
		if (popExist) {
			goDown();
		}
	}
	
	static void pop(int r, int c) {	
		visited[r][c] = true;	
		int start = r * C + c;
		samePuyo.clear();
		q.add(start);
		samePuyo.add(start);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			int cr = curr / C;
			int cc = curr % C;
			
			for (int i = 0; i < 4; i++) {
				int nr = cr + d[i][0];
				int nc = cc + d[i][1];
				
				if (!isValid(nr, nc)) continue;
				if (visited[nr][nc]) continue;
				if (map[r][c] != map[nr][nc]) continue;
				
				visited[nr][nc] = true;
				int next = nr * C + nc;
				q.add(next);		
				samePuyo.add(next);	
			}
		}
		
		eliminate();
	}
	
	static void eliminate() {
		int len = samePuyo.size();
		if (len < PUYO) return;
		popExist = true;
		for (int i = 0; i < len; i++) {
			int curr = samePuyo.get(i);
			int r = curr / C;
			int c = curr % C;
			
			map[r][c] = '.';
		}
	}

	static boolean isValid(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
	
	static void goDown() {
		for (int c = 0; c < C; c++) {
			int w = R-1;
			for (int r = R-1; 0 <= r; r--){
				char now = map[r][c];
				
				if (now == '.') continue;
				
				map[w][c] = now;
				w--;				
			}
			while (w >= 0) {
				map[w][c] = '.';
				w--;
			}
		}
	}
}
