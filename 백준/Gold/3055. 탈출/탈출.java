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
	static StringTokenizer st;
	static Deque<Integer> qH = new ArrayDeque<>();
	static List<Integer> waters = new ArrayList<>();
	static char map[];
	static int visited[];
	static int N, M, sr, sc;
	static int d[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N * M];
		visited = new int[N * M];

		for (int r = 0; r < N; r++) {
			String s = br.readLine();
			for (int c = 0; c < M; c++) {
				char cell = s.charAt(c);
				int curr = r * M + c;
				if (cell == 'S') {
					sr = r;
					sc = c;
					cell = '.';
				}
				if (cell == '*') {
					waters.add(curr);
				}
				map[curr] = cell;
			}
		}
		System.out.println(bfs(sr, sc));
	}
	
	static String bfs(int sr, int sc) {
		Arrays.fill(visited, -1);
		int start = sr * M + sc;
		visited[start] = 0;
		qH.add(start);
		
		while(!qH.isEmpty()) {
			floodWater();
			int roundSize = qH.size();
			
			for(int i = 0; i < roundSize; i++) {
				int curr = qH.poll();
				int cr = curr / M;
				int cc = curr % M;
				
				for (int k = 0; k < 4; k++) {
					int nr = cr + d[k][0];
					int nc = cc + d[k][1];
					if (!isValid(nr, nc)) continue;
					
					int next = nr * M + nc;
					if (map[next] == '*' || map[next] == 'X') continue;
					if (visited[next] != -1) continue;
					if (map[next] == 'D') return visited[curr] + 1 +"";
					
					visited[next] = visited[curr] + 1;
					qH.add(next);					
				}
			}
		}
		return "KAKTUS";
	}

	static void floodWater() {
		int waterCnt = waters.size();
		
		for (int i = 0; i < waterCnt; i++) {
			int curr = waters.get(i);
			int cr = curr / M;
			int cc = curr % M;
			
			for (int k = 0; k < 4; k++) {
				int nr = cr + d[k][0];
				int nc = cc + d[k][1];
				if (!isValid(nr, nc)) continue;
				
				int next = nr * M + nc;
				if (map[next] != '.') continue;
				
				map[next] = '*';
				waters.add(next);				
			}
		}
	}
	
	static boolean isValid(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
	
}
