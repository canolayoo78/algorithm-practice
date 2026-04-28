import java.util.*;
import java.io.*;

public class Main { 
	static int INF = Integer.MAX_VALUE;
	
	static int N, M, start, target;
	static int dist[], prev[];
	static List<Edge> graph[];
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        init();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	graph[u].add(new Edge(v, w));
		}
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
    	
        dijkstra();
        findPath();        
	}
	
	static void init() {
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		prev = new int[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
	}
	
	static void dijkstra() {
		pq.clear();
		pq.add(new Edge(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int cv = cur.v;
			
			if (dist[cv] < cur.w) continue;
			if (cv == target) return;
			
			for (Edge next: graph[cv]) {
				int nv = next.v;
				int nw = next.w;
				
				if (dist[cv] + nw < dist[nv]) {
					dist[nv] = dist[cv] + nw;
					prev[nv] = cv;
					pq.add(new Edge(nv, dist[nv]));
				}
			}
		}
	}
	
	static void findPath() {
		int cur = target;
		
		String path = " ";
		int pathLen = 0;
		
		while(cur != 0) {
			path = cur  + " " + path;
			cur = prev[cur];
			pathLen ++;
		}
		
		System.out.println(dist[target] +"\n" + pathLen + "\n" + path);
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