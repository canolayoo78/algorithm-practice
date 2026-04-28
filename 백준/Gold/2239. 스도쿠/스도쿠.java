import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static final int SIZE = 9, MAX_SIZE = SIZE * SIZE ;
	static int map[] = new int[MAX_SIZE];
	static List<Set<Integer>> rowUsed = new ArrayList<>();
	static List<Set<Integer>> colUsed = new ArrayList<>();
	static List<Set<Integer>> boxUsed = new ArrayList<>();
	
	public static void main(String args[]) throws IOException{			
		for (int i = 0; i < SIZE; i++) {
			rowUsed.add(new HashSet<Integer>());
			colUsed.add(new HashSet<Integer>());
			boxUsed.add(new HashSet<Integer>());
		}
		
		for (int r = 0; r < SIZE; r++) {
			String s = br.readLine();
			for (int c = 0; c < SIZE; c++) {
				int cell = s.charAt(c) - '0';
				if (cell != 0) {
					rowUsed.get(r).add(cell);
					colUsed.get(c).add(cell);
					boxUsed.get(getBoxNum(r, c)).add(cell);
				}
				map[r * SIZE + c] = cell;
			}
		}

		fillBlankFrom(0);
		
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				sb.append(map[r * SIZE + c]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);	
	}
	
	static int getBoxNum(int r , int c) {
		return (r / 3) * 3 + (c / 3);
	}
	
	static boolean fillBlankFrom(int index) {
		while(index < MAX_SIZE && map[index] != 0) {
			index++;
		}
		if (index == MAX_SIZE) return true;
		
		int r = index / SIZE;
		int c = index % SIZE;
		int b = getBoxNum(r, c);
		
		for (int num = 1; num <= SIZE; num++) {
			if (isInvalid(r, c, b, num)) continue;
			map[index] = num;
			rowUsed.get(r).add(num);
			colUsed.get(c).add(num);
			boxUsed.get(b).add(num);
			
			if (fillBlankFrom(index) == true) {
				return true;
			}
			
			map[index] = 0;
			rowUsed.get(r).remove(num);
			colUsed.get(c).remove(num);
			boxUsed.get(b).remove(num);
		}
		
		return false;
	}
	
	static boolean isInvalid(int r, int c, int b, int num) {
		return rowUsed.get(r).contains(num) || colUsed.get(c).contains(num) || boxUsed.get(b).contains(num);
	}
}