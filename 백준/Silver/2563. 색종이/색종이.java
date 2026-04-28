import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static final int SIZE = 100;
	static final int PAPER_SIZE = 10;
	static boolean loc[][];
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		loc = new boolean [SIZE][SIZE];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			color(x, y);
		}
		
		int ans = 0;
		for (int x = 1; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				if (loc[x][y]) ans++;
			}
		}
		System.out.println(ans);
		
	}	
	
	static void color(int x, int y) {
		for (int i = 0; i < PAPER_SIZE; i++) {
			for (int j = 0; j < PAPER_SIZE; j++) {
				loc[x + i][y + j] = true;
			}
		}
	}
}