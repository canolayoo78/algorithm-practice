import java.util.*;
import java.io.*;

public class Main { 
	static final int MAX_N = 2000, MAX_W = 1000, MAX_T = 100;
	static final int INF = MAX_N * MAX_W;

	static final int FROM_S = 0;
	static final int FROM_G = 1;
	static final int FROM_H = 2;
	

	static int[] sources = new int[3];
	static int cands[] = new int[MAX_T];
	static int[][] dist = new int[3][MAX_N + 1];
	
	static List<Edge> graph[];
	static List<Integer> ans = new ArrayList<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	static int T;
	static int s, g, h;
	static int n, m, candCnt;
	static int essentialPath;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
	        m = Integer.parseInt(st.nextToken());
	        candCnt = Integer.parseInt(st.nextToken());
	        
	        st = new StringTokenizer(br.readLine());
	        sources[FROM_S] = s = Integer.parseInt(st.nextToken());
	        sources[FROM_G] = g = Integer.parseInt(st.nextToken());
	        sources[FROM_H] = h = Integer.parseInt(st.nextToken());
	        
	        init();
	        
	        for (int i = 0; i < m; i++) {
	            st = new StringTokenizer(br.readLine());
	        	int u = Integer.parseInt(st.nextToken());
	        	int v = Integer.parseInt(st.nextToken());
	        	int w = Integer.parseInt(st.nextToken());
	        	graph[u].add(new Edge(v, w));
	        	graph[v].add(new Edge(u, w));
	        	if ((u == sources[FROM_G] && v == sources[FROM_H]) || 
	        		(u == sources[FROM_H] && v ==  sources[FROM_G])) {
	        		essentialPath = w;
	        	}
			}
	        
	        for (int i = 0; i < candCnt; i++) {
	        	cands[i] = Integer.parseInt(br.readLine());
			}
	        
	        for (int i = 0; i < 3; i++) {
	            dijkstra(sources[i], dist[i]);
	        }
	        
	        for (int i = 0; i < candCnt; i++) {
	        	if (isTarget(cands[i])) {
	        		ans.add(cands[i]);
	        	}
			}
	        Collections.sort(ans);
	        
	        for (int j = 0; j < ans.size(); j++) {
	        	sb.append(ans.get(j)).append(' ');
			}
	        sb.append('\n');
		}      
        System.out.print(sb);
	}
	
	static void init() {
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < 3; i++) {
		    Arrays.fill(dist[i], 1, n+1, INF);
		}
		ans.clear();
		pq.clear();
	}
	
	static void dijkstra(int start, int dist[]) {
		pq.add(new Edge(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int cv = cur.v;
			int cw = cur.w;
			
			if (dist[cv] < cw) continue;
			
			for (Edge next: graph[cv]) {
				int nv = next.v;
				int nw = next.w;
				
				if (dist[nv] > dist[cv] + nw) {
					dist[nv] = dist[cv] + nw;
					pq.add(new Edge(nv, dist[nv]));
				}
			}
		}
	}
	
	static boolean isTarget(int dest) {
	    int shortest = dist[FROM_S][dest];

	    int path1 = dist[FROM_S][g] + essentialPath + dist[FROM_H][dest];
	    int path2 = dist[FROM_S][h] + essentialPath + dist[FROM_G][dest];

	    return shortest == path1 || shortest == path2;
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