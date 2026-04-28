import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int h, w, perim;
	static int[][] d = {{0, 1},{1, 0},{0, -1},{-1, 0}};
	static int[][] input;
	static int[][] ans;
	static int[] round;
	static int[][] coords;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		input = new int[N][M];
		ans = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int minSide = Math.min(N, M);
		for (int i = 0; i < minSide / 2; i++) {
			init(i);
			getCoordsAndRound(i);
			fillRound(i);
		}
		printMap(ans);		
	}
	
	static void init(int i) {
		h = N - 2 * i;
		w = M - 2 * i;
		perim = 2*(h + w) - 4;
		coords = new int[perim][2];
		round = new int[perim];
	}
	
	static void getCoordsAndRound(int s) {
		int index = 0;
		int x = s;
		int y = s;
		
		for (int r = 0; r < 2; r++) {
			for (int i = 0, size = M - 2 * s - 1; i < size; i++) {
				round[index] = input[x][y];
				coords[index][0] = x;
				coords[index][1] = y;
				x += d[2 * r][0];
				y += d[2 * r][1];
				index++;
			}
			for (int i = 0, size = N - 2 * s - 1; i < size; i++) {
				round[index] = input[x][y];
				coords[index][0] = x;
				coords[index][1] = y;
				x += d[2 * r + 1][0];
				y += d[2 * r + 1][1];
				index++;
			}
		}
	}
	
	static void fillRound(int s) {	
		int index = R % perim;
		for (int i = 0; i < perim; i++) {
			ans[coords[i][0]][coords[i][1]] = round[index];
			index = (index + 1) % perim;
		}
	}
	
	static void printMap(int [][] map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]+ " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
