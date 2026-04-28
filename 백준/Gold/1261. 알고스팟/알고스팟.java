import java.util.*;
import java.io.*;

public class Main { 
	static final int MAX = 100;
	static final int INF = MAX * MAX;

	static boolean [][] isWall;
	static int [][] dist;
	static int [][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static PriorityQueue<State> pq = new PriorityQueue<>();

	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
		
        init();
        
        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
            	isWall[r][c] = line.charAt(c) == '1'? true: false;
            }
        }
        
        dijkstra(0, 0);
        System.out.print(dist[N-1][M-1]);
	}
	
	static void init() {
		isWall = new boolean[N][M];
        dist = new int[N][M];
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
            	dist[r][c] = INF;
            }
        }
	}
	
	static void dijkstra(int sr, int sc) {
		pq.add(new State(sr, sc, 0));
		dist[sr][sc] = 0;
		
		while(!pq.isEmpty()) {
			State cur = pq.poll();
			int cr = cur.r;
			int cc = cur.c;
			int cb = cur.breakCnt;
			
			if (dist[cr][cc] < cb) continue;
			if (cr == M - 1 && cc == N - 1) {
				return;
			}
			
			for (int k = 0; k < 4; k++) {
				int nr = cur.r + d[k][0];
				int nc = cur.c + d[k][1];
				
				if (!isValid(nr, nc)) continue;
				
				int nb = 0;
				if (isWall[nr][nc]) ++nb;
				
				if (dist[nr][nc] > dist[cr][cc] + nb) {
					dist[nr][nc] = dist[cr][cc] + nb;
					pq.add(new State(nr, nc, dist[nr][nc]));
				}
				
			}
		}
	}
	
	static boolean isValid(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
}

class State implements Comparable<State>{
	int r;
	int c;
	int breakCnt;
	
	public State(int r, int c, int breakCnt) {
		this.r = r;
		this.c = c;
		this.breakCnt =breakCnt;
	}
	
	@Override
	public int compareTo(State s) {
		return Integer.compare(this.breakCnt, s.breakCnt);
	}
}