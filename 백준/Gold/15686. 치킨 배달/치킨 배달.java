import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
    static Point houses[], chickens[];
    static int survivedIndex[];
    static int distCH[][];
    static int N, M;
    static int houseCnt, chickenCnt;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        houses = new Point[2 * N];
        chickens = new Point[13];
        houseCnt = 0;
        chickenCnt = 0;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		int cell = Integer.parseInt(st.nextToken());
        		if (cell == 1) {
        			houses[houseCnt++] = new Point(i, j);
        		}
        		else if (cell == 2) {
        			chickens[chickenCnt++] = new Point(i, j);
        		}
        	}
        }

        distCH = new int[chickenCnt][houseCnt];
        survivedIndex = new int[M];
        init();
        pickSurvived(0, 0);
        System.out.println(min);
    }

    static void init() {
    	for (int c = 0; c < chickenCnt; c++) {
        	for (int h = 0; h < houseCnt; h++) {
        		distCH[c][h] = calcDist(chickens[c], houses[h]);
        	}
        }
    }
    
    static void pickSurvived(int depth, int survived) {
    	if (survived == M) {
    		int cityDist = calcCityDist();
    		if (cityDist < min) min = cityDist;
    		return;
		}
    	
    	if (depth == chickenCnt) return;
    	if (survived + (chickenCnt - depth) < M) return;
    	
    	survivedIndex[survived] = depth;
    	pickSurvived(depth + 1, survived + 1);
    	survivedIndex[survived] = 0;
    	pickSurvived(depth + 1, survived);
    }
    
    static int calcCityDist() {
    	int cityDist = 0;
    	for (int h = 0; h < houseCnt; h++) {
    		int minDist = Integer.MAX_VALUE;
    		for (int c: survivedIndex) {
    			if (distCH[c][h] < minDist) {
    				minDist = distCH[c][h];
    			}
    		}
    		cityDist += minDist;
    	}
    	return cityDist;
    }
   
    static int calcDist(Point a, Point b) {   	
    	return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }
}

class Point{
	int r, c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}