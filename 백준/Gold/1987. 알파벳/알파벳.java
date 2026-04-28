import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char map[];
    static boolean visited[] = new boolean[26];
    static int d[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C, max = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char [R*C];
        for (int r = 0; r < R; r++) {
        	String line = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r * C + c] = line.charAt(c);
			}
		}
        
        visited[map[0] -'A'] = true;
        move(0, 1);
        System.out.println(max);
	}
	
	static void move(int now, int move) {
		if (move > max) {
			max = move;
		}
		
		int r = now / C;
		int c = now % C;
		
		for (int k = 0; k < 4; k++) {
			int nr = r + d[k][0];
			int nc = c + d[k][1];
			
			if (!isValid(nr, nc)) continue;
			int next = nr * C + nc;
			int nextC = map[next] - 'A';
			if (visited[nextC]) continue;
			
			visited[nextC] = true;
			move(next, move + 1);
			visited[nextC] = false;
		}
	    
	}
	
	static boolean isValid(int r, int c) {
		return 0 <= r && r < R &&  0 <= c && c < C; 
	}
}

