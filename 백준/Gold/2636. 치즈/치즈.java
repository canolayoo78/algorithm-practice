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
	static boolean visited[];
	static int map[];
	static int R, C;
	static int d[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; 
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R*C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r * C + c] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0, prev = 0, now = 0;
		Deque<Integer> q = new ArrayDeque<>(); 
		visited = new boolean[R*C];
		visited[0] = true;
		q.add(0);
		
		while(true) {
			q = bfs(q);
			now = q.size();
			if (now == 0) break;
			time++;
			prev = now;
		}
		System.out.println(time+"\n"+prev);
	}
	
	static Deque<Integer> bfs(Deque<Integer> q) {	
		Deque<Integer> melted = new ArrayDeque<>(); 
		
		while(!q.isEmpty()) {
			int now = q.poll();
			int r = now / C;
			int c = now % C;
			for (int k = 0; k < 4; k++) {
				int nr = r + d[k][0];
				int nc = c + d[k][1];
				if (isNotValid(nr, nc)) continue;
				int next = nr * C + nc;
				if (visited[next]) continue;
				visited[next] = true;
				if (map[next] == 0) {
					q.add(next);
				}
				else {
					map[next] = 0;
					melted.add(next); 
				}
			}
		}
		return melted;
	}
		
	static boolean isNotValid(int r, int c) {
		return !(0 <= r && r < R && 0 <= c && c < C);
	}
}