import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n = 19;
	public static int[][] map = new int[n + 1][n + 1];
	public static int[] ans = new int[3];
	public static int d[][] = {{-1, 1}, {0, 1}, {1, 0}, {1, 1}};
	
	public static void checkWin() {
		for (int j = 1; j < n + 1; j++) {
			for (int i = 1; i < n + 1; i++) {
				
				if (map[i][j] != 0)	{
					ans = new int[]{0, i, j};
					int startStone = map[i][j];
					
					for (int k = 0; k < 4; k++) {
						int ni = i + d[k][0];
						int nj = j + d[k][1];
						int pi = i - d[k][0];
						int pj = j - d[k][1];
						
						if (((0 < pi)&&(pi <= n)&&(0 < pj)&&(pj <= n)) && (map[pi][pj] == startStone))
								continue;								
						
						int continuousLength = 1;
						
						while ((0 < ni)&&(ni <= n)&&(0 < nj)&&(nj <= n)) {
							if (map[ni][nj] == startStone) {
								continuousLength++;
								ni += d[k][0];
								nj += d[k][1];
							}
							else
								break;
						}
						
						if (continuousLength == 5) {
							ans = new int[]{startStone, i, j};
							return;
						}
					}		
				}
			}
		}
		return;
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i < n + 1; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for(int j= 1; j< n + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		checkWin();
		
		System.out.println(ans[0]);
		if (ans[0] != 0)
			System.out.printf("%d %d", ans[1], ans[2]);
	}
}