import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] starMap;
	static int n;
	
	static void checkStar(int r, int c, int size) {
		if (size == 3) {
			starMap[r][c + 2] = true;
			for (int i = 1; i <= 2; i++)
				starMap[r+1][c+2*i-1] = true;
			for (int i = 0; i < 5; i++)
				starMap[r+2][c+i] = true;
		}
		else {
			int downSize = size / 2;
			checkStar(r, c + downSize, downSize);
			checkStar(r + downSize, c, downSize);
			checkStar(r + downSize, c + size, downSize);
		}
	}
	
	static void printStar() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n - 1; j++){
				if (starMap[i][j])
					sb.append('*');
				else
					sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		n = Integer.parseInt(br.readLine().trim());
		starMap = new boolean[n][2 * n - 1];
		
		checkStar(0,0,n);
		printStar();
    }
}