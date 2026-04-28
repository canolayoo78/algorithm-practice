import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int SIZE = 8;
	static int map [][] = new int[SIZE][SIZE];
	static int cctvLoc[][] = new int[SIZE][2];
	static int d[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int cctvRot [] = {0, 4, 2, 4, 4, 1};
	static int cctvTypes [][][] = {
			{{0}}, 
			{{0}, {1}, {2}, {3}}, // 1번
			{{0, 2}, {1, 3}}, // 2번
			{{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번
			{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번
			{{0, 1, 2, 3}} // 5번
	};
	static int cctvCnt = 0, minBlindSpot = Integer.MAX_VALUE;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				int cell = Integer.parseInt(st.nextToken());
				if (cell != 0 && cell != 6) {
					cctvLoc[cctvCnt][0] = r;
					cctvLoc[cctvCnt][1] = c;
					cctvCnt++;
				}
				map[r][c] = cell;
			}
		}
		init();
		dfs(0);
		System.out.println(minBlindSpot); 
	}
	
	static void init() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != 0) {
					map[r][c] += cctvCnt;
				}
			}
		}
	}
	
	static void dfs(int depth) {
		if(depth == cctvCnt) {
			int blindSpot = calcBlindSpot();
			if (blindSpot < minBlindSpot) {
				minBlindSpot = blindSpot;
			}
			return;			
		}
		
		int r = cctvLoc[depth][0];
		int c = cctvLoc[depth][1];
		int type = map[r][c] - cctvCnt;
		int rotateDirs[][] = cctvTypes[type];
		
		for (int k = 0; k < cctvRot[type]; k++) {
			watch(r, c, rotateDirs[k], true);
			dfs(depth + 1);
			watch(r, c, rotateDirs[k], false);
		}
	}
	
	static int calcBlindSpot() {
		int blindSpot = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) blindSpot++;
			}
		}
		return blindSpot;
	}
	
	static void watch(int r, int c, int watchDir[], boolean on) {
		int value = on? 1 : -1;
		
		for (int i = 0; i < watchDir.length; i++) {
			int dir = watchDir[i];
			int nr = r, nc = c;
			while(true) {
				nr += d[dir][0];
				nc += d[dir][1];
				if (!isValid(nr, nc)) break;
				if (map[nr][nc] == cctvCnt + 6) break;
				if (map[nr][nc] <= cctvCnt) {
					map[nr][nc] += value;
				}
			}
		}
	}
	
	static boolean isValid(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
	
}

