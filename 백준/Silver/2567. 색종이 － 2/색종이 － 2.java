import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Deque<Integer> q = new ArrayDeque<>();
	static final int BOARD_SIZE = 102, PAPER_SIZE = 10;
	static boolean visited [] = new boolean [BOARD_SIZE * BOARD_SIZE];
	static boolean attached [] = new boolean [BOARD_SIZE * BOARD_SIZE];
	static int d[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int N, perimeter = 0;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			attach(r, c);
		}
		
		for (int r = 0; r < BOARD_SIZE; r++) {
			for (int c = 0; c < BOARD_SIZE; c++) {
				int curr = r * BOARD_SIZE + c;
				if (attached[curr] == false) {
					q.add(curr);
					visited[curr] = true;
				}
			}
		}
		
		bfs();
		System.out.println(perimeter); 
	}
	
	static void attach(int sr, int sc) {
		for (int nr = sr; nr < sr + PAPER_SIZE; nr++) {
			for (int nc = sc; nc < sc + PAPER_SIZE; nc++) { 
				int next = nr * BOARD_SIZE + nc;
				if(!attached[next]) attached[next] = true;
			}
		}
	}
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			int c = q.poll();
			int cr = c / BOARD_SIZE;
			int cc = c % BOARD_SIZE;
			
			for (int k = 0; k < 4; k++) {
				int nr = cr + d[k][0];
				int nc = cc + d[k][1];
				if (!isValid(nr, nc)) continue;
				
				int next = nr * BOARD_SIZE + nc;
				if (visited[next]) continue;

				if (attached[next]) {
					perimeter++;
				}
				else {
					q.add(next);
					visited[next] = true;
				}
			}
			
		}
		
	}
	
	static boolean isValid(int r, int c) {
		return 0 <= r && r < BOARD_SIZE && 0 <= c && c < BOARD_SIZE;
	}
	
}

