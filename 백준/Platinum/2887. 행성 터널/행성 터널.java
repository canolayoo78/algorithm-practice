import java.util.*;
import java.io.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static List<Edge> edges = new ArrayList<>();
	static int stars[][], repOf[], memberOf[];
	static int ans = 0;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
		N = Integer.parseInt(br.readLine());
		stars = new int [N][4];
		repOf = new int [N];
		memberOf = new int [N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Integer.parseInt(st.nextToken());
			stars[i][1] = Integer.parseInt(st.nextToken());
			stars[i][2] = Integer.parseInt(st.nextToken());
			stars[i][3] = i;
		}
        
		init();
		kruskal();
		System.out.println(ans);
	}

	static void init() {
		for (int i = 0; i < 3; i++) {
			makeEdgesWith(i);
		}
		Collections.sort(edges);
		
		for (int i = 0; i < N; i++) {
			repOf[i] = i;
			memberOf[i] = 1;
		}
	}
	
	static int find(int x) {
		if (repOf[x] == x) {
			return x;
		}
		repOf[x] = find(repOf[x]);
		return repOf[x];
	}
	
	static boolean union(int a, int b) {
		int repA = find(a);
		int repB = find(b);
		
		if (repA == repB) {
			return false;
		}
		
		if (memberOf[repB] < memberOf[repA]) {
			memberOf[repA] += memberOf[repB];
			repOf[repB] = repA;
		}
		else {
			memberOf[repB] += memberOf[repA];
			repOf[repA] = repB;
		}
		return true;
	}
	
	static void kruskal() {
		for (Edge e: edges) {
			if (union(e.u, e.v)) {
				ans += e.w;
			}
		}
	}
	
	static void makeEdgesWith(int axis) {
		Arrays.sort(stars, (a, b) -> Integer.compare(a[axis], b[axis]));
		
		// 만들어진 별 순서에 대해서 인접한 별들 간 간선 생성
		for (int i = 1; i < N; i++) {
			edges.add(new Edge(stars[i-1][3], stars[i][3], Math.abs(stars[i-1][axis] - stars[i][axis])));
		}		
	}
}

class Edge implements Comparable<Edge>{
	int u;
	int v;
	int w;
	
	Edge (int u, int v, int w){
		this.u = u;
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.w, o.w);
	}
	
	
}