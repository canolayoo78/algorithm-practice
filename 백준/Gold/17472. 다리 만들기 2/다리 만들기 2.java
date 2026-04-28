import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {		
	static Deque<Integer> q = new ArrayDeque<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static int map[];
	static int repOf[], memberOf[];
	static int d[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean visited[];
	static int N, M, islandCnt = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N*M];
		visited = new boolean[N*M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				int pos = r * M + c;
				map[pos] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				int pos = r * M + c;
				if (map[pos] == 0) continue;
				if (visited[pos]) continue;
				bfs(pos);
				islandCnt ++;
			}
		}
		
		findBridges();
		System.out.println(kruskal());
	}
	
	static void bfs(int start) {
		q.add(start);
		visited[start] = true;
		map[start] = islandCnt;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			int cr = cur / M;
			int cc = cur % M;
			
			for (int k = 0; k < 4; k++) {
				int nr = cr + d[k][0];
				int nc = cc + d[k][1];
				
				if (!isValid(nr, nc)) continue;
				int next = nr * M + nc;
				if (map[next] == 0) continue;
				if (visited[next]) continue;
				
				map[next] = islandCnt;
				visited[next] = true;
				q.add(next);
			}
		}
	}
	
	static void findBridges() {
		for (int r = 0; r < N; r++) {
	        scanLine(r, 0, 0, 1);
	    }

	    for (int c = 0; c < M; c++) {
	        scanLine(0, c, 1, 0);
	    }
	}
	
	static void scanLine(int sr, int sc, int dr, int dc) {
	    int start = 0;
	    int len = 0;

	    int r = sr, c = sc;
	    while (isValid(r, c)) {
	        int cell = map[r * M + c];

	        if (cell == 0) {                 
	            if (start != 0) len++;
	        } 
	        else {                         
	            if (start == 0 || start == cell) {            
	                start = cell;
	                len = 0;
	            } 
	            else {                     
	                if (len > 1) {
	                    pq.add(new Edge(start, cell, len));
	                }
	                start = cell;          
	                len = 0;
	            }
	        }

	        r += dr;
	        c += dc;
	    }
	}
	
	static int kruskal() {
		repOf = new int[islandCnt];
		memberOf = new int[islandCnt];
		for (int i = 0; i < islandCnt; i++) {
			repOf[i] = i;
			memberOf[i] = 1;
		}
		
		int total = 0;
		int connected = 1;
		
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (union(e.start, e.end)) {
				total += e.len;
				connected ++;
				if (connected == islandCnt - 1) {
					return total == 0? -1: total;
				}
			}
		}
		return -1;
	}
	
	static int find(int x) {
		if (repOf[x] == x) return x;
		repOf[x] = find(repOf[x]);
		return repOf[x];
	}
	
	static boolean union(int a, int b) {
		int repA = find(a);
		int repB = find(b);
		
		if (repA == repB) return false;
		
		if (memberOf[repA] < memberOf[repB]) {
			memberOf[repB] += memberOf[repA];
			repOf[repA] = repB;
		}
		else {
			memberOf[repA] += memberOf[repB];
			repOf[repB] = repA;
		}
		return true;
	}
	
	
	static void printMap() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(map[r * M + c] +" ");
			}
			System.out.println();
		}
	}
	
	static boolean isValid(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
}

class Edge implements Comparable<Edge>{
	int start;
	int end;
	int len;
	
	public Edge(int start, int end, int len) {
		this.start = start;
		this.end = end;
		this.len = len;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.len, o.len);
	}
}