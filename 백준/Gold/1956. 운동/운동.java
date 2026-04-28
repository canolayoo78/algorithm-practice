import java.util.*;
import java.io.*;

public class Main { 
	static int INF = 1_000_000_000;
	
	static int V, E;
	static int dist[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        init();
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	dist[u][v] = w;
		}
        
        floydWarshall();        
        System.out.println(findMinCycle());
	}
	
	static void init() {
		dist = new int[V + 1][V + 1];
		
		for (int i = 1; i <= V; i++) {
			Arrays.fill(dist[i], INF);
		}
	}
	
	static void floydWarshall() {
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
	
	static int findMinCycle() {
        int min = INF;
		for (int i = 1; i <= V; i++) {
			min = Math.min(min, dist[i][i]);
		}
		return min == INF? -1: min;
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
	public int compareTo(Edge e) {
		return Integer.compare(this.w, e.w);
	}
}