import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Deque<Integer> q = new ArrayDeque<>();
	static int d[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int sea[], distance[];
	static int N, time = 0, eatCnt = 0, sharkSize = 2;

	public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        sea = new int[N*N];
        distance = new int[N*N];
        
        int sr = 0, sc = 0;
        for (int r = 0; r < N; r++) {
    		st = new StringTokenizer(br.readLine());
    		for (int c = 0; c < N; c++) {
    			int cell = Integer.parseInt(st.nextToken());
    			if (cell == 9) {
    				sr = r; 
    				sc = c;
    				cell = 0;
    			}
    			sea[r*N + c] = cell;
    		}
    	}
        
        int now = sr*N + sc;
        while (true) {
        	now = bfs(now);
        	if(now == -1) break;
        }
        System.out.println(time);
	}
    
	
	static int bfs(int start) {
		q.clear();
		int target = Integer.MAX_VALUE;
		q.add(start);
		Arrays.fill(distance, -1);
		distance[start] = 0;
		
		while(!q.isEmpty()) {
			int roundSize = q.size();
			
			for (int i = 0; i < roundSize; i++) {
				int curr = q.poll();
				int cr = curr / N;
				int cc = curr % N;
				
				for (int k = 0; k < 4; k++) {
					int nr = cr + d[k][0];
					int nc = cc + d[k][1];
					
					if (isNotValid(nr, nc)) continue;
					int next = nr * N + nc;
					if (distance[next] != -1) continue;
					if (sharkSize < sea[next]) continue;
					
					distance[next] = distance[curr] + 1;
					if (0 < sea[next] && sea[next] < sharkSize) {
						if (next < target) {
							target = next;
						}
					}
					else {
						q.add(next);
					}		
				}
			}
			if (target != Integer.MAX_VALUE) {
				return eat(target);
			}			
		}

		return -1;
	}
	
	static int eat(int target) {
		time += distance[target];
		sea[target] = 0;
		eatCnt += 1;
		if (eatCnt == sharkSize) {
			sharkSize++;
			eatCnt = 0;
		}
		return target;
	}
	
	
	static boolean isNotValid(int r, int c) {
		return !(0 <= r && r < N && 0 <= c && c < N);
	}
}
