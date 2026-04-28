import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {	
	static final double INF = Double.MAX_VALUE;
	
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static double starts[][];
	static double key[];
	static boolean isMST[];
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		
		starts = new double[N][2];
		key = new double[N];
		isMST = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			starts[i][0] = Double.parseDouble(st.nextToken());
			starts[i][1] = Double.parseDouble(st.nextToken());
			key[i] = INF;
		}
		
		pq.add(new Edge(0, 0));	
		key[0] = 0;
		double total = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int now = cur.v;
			if (isMST[now]) continue;
			
			isMST[now] = true;
			total += cur.w;
			
			for (int next = 0; next < N; next++) {
				if (now == next) continue;
				if (isMST[next]) continue;
				double nw = calcDist(now, next);
				if (key[next] < nw) continue;
				key[next] = nw;
				pq.add(new Edge(next, nw));
			}
		}
		
		System.out.println(total);
		
	}
	
	static double calcDist(int now, int next) {
		double ax = starts[now][0];
		double ay = starts[now][1];
		double bx = starts[next][0];
		double by = starts[next][1];
		
		return Math.sqrt((ax - bx) * (ax - bx) + (ay - by) * (ay - by));
	}
	
}

class Edge implements Comparable<Edge>{
	int v;
	double w;
	
	public Edge(int v, double w) {
		this.v = v;
		this.w = w;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.w, o.w);
	}
}
