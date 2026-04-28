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
	static int N, M;
	
	static class Edge implements Comparable<Edge>{
	    int start, end, weight;
	    Edge(int start, int end, int weight) {
	    	this.start = start;
	        this.end = end;
	        this.weight = weight;
	    }
	    @Override
	    public int compareTo(Edge o) {
	        return Integer.compare(this.weight, o.weight);
	    }
	}
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges.add(new Edge(s, e, w));
		}
		Collections.sort(edges); 
		
		System.out.println(kruskal());
	}

	static int kruskal() {
		repOf = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			repOf[i] = i;
		}
		memberCntOf = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			memberCntOf[i] = 1;
		}
		
		int total = 0;
		int connectedEdgeCnt = 0;
		for (int idx = 0; idx < M && connectedEdgeCnt < N; idx++) {
			int s = edges.get(idx).start;
			int e = edges.get(idx).end;
			int w = edges.get(idx).weight;
			
			if (union(s, e)) {
				total += w;
				connectedEdgeCnt++;
			}
		}
        
		return total;
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
