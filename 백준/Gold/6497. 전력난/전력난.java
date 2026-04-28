import java.util.*;
import java.io.*;

public class Main {
	static List<Edge> edges = new ArrayList<>();
	static int repOf[], memberOf[];
	static int M, N, totalCost, remainCost;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if (M == 0 && N == 0) {
				break;
			}
			
			repOf = new int [M];
			memberOf = new int [M];
			totalCost = 0;
			remainCost = 0;
			edges.clear();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				totalCost += z;
				edges.add(new Edge(x, y, z));
			}
	        
			init();
			kruskal();
			System.out.println(totalCost - remainCost);
        }
	}
	
	static void init() {
		Collections.sort(edges);
		
		for (int i = 0; i < M; i++) {
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
				remainCost += e.w;
			}
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