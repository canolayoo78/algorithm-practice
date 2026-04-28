import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int operateNum = Integer.parseInt(st.nextToken());
			operate(operateNum);
		}
		printMap(map, N, M);
	}
	
	static void operate(int n) {
		switch(n) {
		case 1: 
			horizontalFlip();
			break;
		case 2:
			verticalFlip();
			break;
		case 3:
			rotate90();
			break;
		case 4:
			rotate270(); 
			break;
		case 5:
			suffleRight();
			break;
		case 6:
			suffleLeft();
			break;
		}
	}
	
	static void horizontalFlip() {
		int[] temp;
		
		for (int c = 0; c < M; c++) {
			temp = new int[N];
			for (int r = 0; r < N; r++) {
				temp[r] = map[r][c];
			}
			for (int r = N-1; 0 <= r; r--) {
				map[r][c] = temp[N-1-r];
			}
		}
	}
	
	static void verticalFlip() {
		int[] temp;
		
		for (int r = 0; r < N; r++) {
			temp = new int[M];
			for (int c = 0; c < M; c++) {
				temp[c] = map[r][c];
			}
			for (int c = M-1; 0 <= c; c--) {
				map[r][c] = temp[M-1-c];
			}
		}
		
	}
	
	static void rotate90()  {
		int[][] temp = new int[M][N];
		for (int c = 0; c < M; c++){ 
			for (int r = 0; r < N; r++) { 
				temp[c][N-1-r] = map[r][c];
			}
		}
		map = temp;
		M = swap(N,  N = M);
	}
	
	static void rotate270()  {
		int[][] temp = new int[M][N];
		for (int r = 0; r < N; r++){ 
			for (int c = 0; c < M; c++) { 
				temp[M-1-c][r] = map[r][c];
			}
		}
		map = temp;
		M = swap(N,  N = M);
	}
	
	
	static void suffleLeft() {
		 int h = N / 2, w = M / 2;

	    int[][] temp = new int[h][w];
	    
	    for (int r = 0; r < h; r++) {
	        System.arraycopy(map[r], 0, temp[r], 0, w);
	    }

	    for (int r = 0; r < h; r++) {
	        System.arraycopy(map[r], w, map[r], 0, w);
	    }

	    for (int r = 0; r < h; r++) {
	        System.arraycopy(map[h + r], w, map[r], w, w);
	    }

	    for (int r = 0; r < h; r++) {
	        System.arraycopy(map[h + r], 0, map[h + r], w, w);
	    }
	    
	    for (int r = 0; r < h; r++) {
	        System.arraycopy(temp[r], 0, map[h + r], 0, w);
	    }
	}
	
	static void suffleRight() {
		int h = N / 2, w = M / 2;

	    int[][] temp = new int[h][w]; 

	    for (int r = 0; r < h; r++) {
	        System.arraycopy(map[r], 0, temp[r], 0, w);
	    }

	    for (int r = 0; r < h; r++) {
	        System.arraycopy(map[h + r], 0, map[r], 0, w);
	    }

	    for (int r = 0; r < h; r++) {
	        System.arraycopy(map[h + r], w, map[h + r], 0, w);
	    }

	    for (int r = 0; r < h; r++) {
	        System.arraycopy(map[r], w, map[h + r], w, w);
	    }

	    for (int r = 0; r < h; r++) {
	        System.arraycopy(temp[r], 0, map[r], w, w);
	    }
		
	}
	
	static void printMap(int[][] map, int N, int M) {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(map[r][c] +" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int swap(int a, int b) {
		return a;
	}
}
