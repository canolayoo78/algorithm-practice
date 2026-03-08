import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {	
	static final int INF = Integer.MAX_VALUE;
	
	static List<List<Edge>> graph = new ArrayList<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static int distances[];
	static int V, E, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		distances = new int[V+1];
		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
			distances[i] = INF;
		}
		
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Edge(v, w));
		}
		
		pq.add(new Edge(K, 0));	
		distances[K] = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (distances[cur.v] < cur.w) {
				continue;
			}
			
			for (Edge next: graph.get(cur.v)) {
				if (distances[next.v] > distances[cur.v] + next.w) {
					distances[next.v] = distances[cur.v] + next.w;
					pq.add(new Edge(next.v, distances[next.v]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < V + 1; i++) {
			if (distances[i] == INF) {
				sb.append("INF\n");
			}
			else {
				sb.append(distances[i]).append('\n');
			}
		}
		System.out.println(sb);
		
	}
	
}

class Edge implements Comparable<Edge>{
	int v;
	int w;
	public Edge(int v, int w) {
		this.v = v;
		this.w = w;
	}
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.w, o.w);
	}
	
}
