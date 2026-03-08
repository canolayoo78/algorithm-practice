import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static List<Edge> edges = new ArrayList<>();
	static int repOf[];
	static int memberCntOf[];
	static boolean cut[];
	static int N, M;
	static long K;
	
	static class Edge implements Comparable<Edge>{
	    int to, stone;
	    Edge(int to, int stone) {
	        this.to = to;
	        this.stone = stone;
	    }
	    @Override
	    public int compareTo(Edge o) {
	        return Integer.compare(this.stone, o.stone);
	    }
	}
	
	public static void main(String[] args) throws IOException{
		init();
		System.out.println(kruskal());
	}

	static String kruskal() {
		int connectedEdgeCnt = 0;
		for (int from = 1; from <= N; from++) {
			if (cut[from]) continue;
			if (union(from, from % N +1)){
				connectedEdgeCnt++;
			}
		}
		if (connectedEdgeCnt == N-1) return "YES";
		
		long stoneCnt = 0;
		for (int idx = 0; idx < N && connectedEdgeCnt < N; idx++) {
			int to = edges.get(idx).to;
			int stone = edges.get(idx).stone;
			if (union(0, to)) {
				stoneCnt += stone;
				if (stoneCnt > K) return "NO";
				connectedEdgeCnt++;
			}
		}
		return "YES";
	}
	
	static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		repOf = new int[N+1];
		memberCntOf = new int[N+1];
		cut = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			repOf[i] = i;
			memberCntOf[i] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i <= N; i++) {
			int len = Integer.parseInt(st.nextToken());
			edges.add(new Edge(i, len));
		}
		Collections.sort(edges); 
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int from = Math.min(a, b);
			int to = Math.max(a, b);
			if (from == 1 && to == N) {
				cut[N] = true;
			}
			else{
				cut[from] = true;
			}
		}
		
		
	}
	
	static int findRepOf(int n) {
		if (repOf[n] == n) {
			return n;
		}
		else {
			repOf[n] = findRepOf(repOf[n]);
			return repOf[n];
		}
	}
	
	static boolean union(int a, int b) {
		int repA = findRepOf(a);
		int repB = findRepOf(b);
		
		if (repA == repB) {
			return false;
		}
		else if (memberCntOf[repA] < memberCntOf[repB]) {
			memberCntOf[repB] += memberCntOf[repA];
			repOf[repA] = repB;
		}
		else {
			memberCntOf[repA] += memberCntOf[repB];
			repOf[repB] = repA;
		}
		return true;
	}
}
