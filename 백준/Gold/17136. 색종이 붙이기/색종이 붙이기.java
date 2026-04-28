import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int BOARD_SIZE = 10, PAPER_TYPE = 5;
    static boolean covered[][] = new boolean[BOARD_SIZE][BOARD_SIZE];
    static int useCnt[] = new int[PAPER_TYPE + 1];
    static int min = Integer.MAX_VALUE, rest = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int r = 0; r < BOARD_SIZE; r++) {
        	st = new StringTokenizer(br.readLine());
        	for (int c = 0; c < BOARD_SIZE; c++) {
        		int cell = Integer.parseInt(st.nextToken());
        		if (cell == 0) {
        			covered[r][c] = true;
        		}
        		else{
        			covered[r][c] = false;
        			rest ++;
        		}
        	}
		}
        
        cover(0, 0, rest);
        System.out.println(min == Integer.MAX_VALUE? -1 : min);
	}
	
    static void cover(int index, int count, int rest) {
    	if (rest == 0) {
    		if (count < min) {
    			min = count;
    		}
    		return;
    	}
    	
    	int next = findNextFrom(index);
    	int r = next / BOARD_SIZE;
    	int c = next % BOARD_SIZE;
    	
    	for (int s = 5; s > 0; s--) {
			if (!canCover(r,c,s)) continue; 
			if (useCnt[s] >= 5) continue;
			
			coverWith(r, c, s, true);
			useCnt[s] ++;
			cover(next, count + 1, rest - s * s);
			coverWith(r, c, s, false);
			useCnt[s] --;
		}
    	
    }
    
    static int findNextFrom(int index) {
    	int r, c;
    	while (index < BOARD_SIZE * BOARD_SIZE) {
    		r = index / BOARD_SIZE;
        	c = index % BOARD_SIZE;
        	if (!covered[r][c]) return index;
        	index++;
    	}
    	return -1;
    }
    
    static boolean canCover(int r, int c, int size) {
    	if ( r + size > BOARD_SIZE || c + size > BOARD_SIZE) return false;
    	
    	for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
        		if (covered[r + i][c + j]) return false;
        	}
        }
    	return true;
    }
    
    static void coverWith(int r, int c, int size, boolean state) {
    	for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
        		covered[r + i][c + j] = state;
        	}
        }
    }
	
    
}

