import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int d[][] = {{-1, -1},{-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; 
	static boolean map[];
	static int w, h;
	
	public static void main(String[] args) throws IOException{
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (h == 0 && w == 0) break;
			map = new boolean[w * h];
			for (int r = 0; r < h; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < w; c++) {
					map[r * w + c] = st.nextToken().equals("1");
				}
			}
			
			int cnt = 0;
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (map[r * w + c]) {
						dfs(r * w + c);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}	
	
	static void dfs(int start) {
		Deque<Integer> q = new ArrayDeque<>();
		map[start] = false;
		q.add(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			int r = now / w;
			int c = now % w;
			for (int i = 0; i < 8; i++) {
				int nr = r + d[i][0];
				int nc = c + d[i][1];
				int next = nr * w + nc;
				if(isValid(nr, nc) && map[next]) {
					q.add(next);
					map[next] = false;
				}
			}
		}
	}
	
	static boolean isValid(int r, int c) {
		return 0 <= r && r < h && 0 <= c && c < w;
	}
}