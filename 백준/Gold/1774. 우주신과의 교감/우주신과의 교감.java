import java.util.*;
import java.io.*;

public class Main { 
	static double total = 0, loc[][];
	static int N, M, count = 0, repOf[],membersOf[];
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
        loc = new double [N + 1][2];
        repOf = new int [N + 1];
        membersOf = new int [N + 1];
        
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	loc[i][0] = Integer.parseInt(st.nextToken());
        	loc[i][1] = Integer.parseInt(st.nextToken());
		}

        kruskalInit();
        
        for (int m = 0; m < M; m++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	union(a, b);
		}

        distInit();
        
        kruskal();
        
		System.out.printf("%.2f", total);
	}

	static void kruskalInit() {
		for (int i = 1; i <= N; i++) {
			repOf[i] = i;
			membersOf[i] = 1;
		}
	}
	
	static void distInit() {
		for (int i = 1; i <= N; i++) {
		    repOf[i] = find(i);
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (repOf[i] == repOf[j]) continue;
				pq.add(new Edge(i, j, getSquareDist(i, j)));
			}
		}		
	}
	
	static void kruskal() {
		while (count != N-1){
			Edge e = pq.poll();
			if (union(e.u, e.v)) {
				total += Math.sqrt(e.w);
			}
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
		
		if (repA == repB) return false;
		
		count++;
		if (membersOf[repA] < membersOf[repB]) {
			membersOf[repB] += membersOf[repA];
			repOf[repA] = repB;
		}
		else {
			membersOf[repA] += membersOf[repB];
			repOf[repB] = repA;
		}
		return true;
	}
	
	static double getSquareDist(int i, int j) {
		double ix = loc[i][0];
		double iy = loc[i][1];
		double jx = loc[j][0];
		double jy = loc[j][1];
		
		return (ix - jx) * (ix - jx) + (iy - jy) * (iy - jy);
	}
}

class Edge implements Comparable<Edge>{
	int u;
	int v;
	double w;
	
	public Edge(int u, int v, double w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}	
	
	public int compareTo(Edge o) {
		return Double.compare(this.w, o.w);
	}
}