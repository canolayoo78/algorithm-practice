import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int target;
	static int[][] map;
	static int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int num = 1;
	static int distance = 1;
	static int direction = 0;
	static int[] ans = new int[2];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		target = Integer.parseInt(br.readLine().trim());
		
		map = new int[N][N];
		solve();
		printMap();
	}
	
	static void solve() {
		int x = N / 2;
		int y = N / 2;
        if (num == target) {
			ans[0] = x+1;
			ans[1] = y+1;
		}
		map[x][y] = num++;
		while(num <= N*N) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < distance; j++) {
					x += d[direction][0];
					y += d[direction][1];
					if (num == target) {
						ans[0] = x+1;
						ans[1] = y+1;
					}
					map[x][y] = num++;
					if (num > N*N) return;
				}
				direction = (direction + 1) % 4;
			}
			distance++;
		}
	}
	
	static void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append("\n");
		}
		sb.append(ans[0] + " " + ans[1]);
		System.out.println(sb.toString());
	}
	
	
}
