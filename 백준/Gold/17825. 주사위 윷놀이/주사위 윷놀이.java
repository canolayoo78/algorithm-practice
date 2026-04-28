import java.util.*;
import java.io.*;

public class Main {
	static final int ROLL = 10, HORSE = 4, START_LEN = 22;
	static int dices [] = new int[ROLL];
	static int max = -1;
	static Location horses[] = new Location [HORSE];
	static Board startBoard, westBoard, southBoard, eastBoard, northBoard;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
		for (int i = 0; i < ROLL; i++) {
			dices[i] = Integer.parseInt(st.nextToken());
		}
		
		startBoard = new Board("start", START_LEN, 0, 2);
		westBoard = new Board("west", 3, 13, 3);
		southBoard = new Board("south", 2, 22, 2);
		eastBoard = new Board("east", 3, 28, -1);
		northBoard = new Board("north", 3, 25, 5);
		
		for (int i = 0; i < HORSE; i++) {
			horses[i] = new Location(startBoard, 0);
		}
		
		dfs(0, 0);
		System.out.println(max);
	}
	
	static void dfs(int depth, int ans){
		if (depth == ROLL) {
			if (max < ans) {
				max = ans;
			}
			return;
		}
		
		for (int i = 0; i < HORSE; i++) {
			if (!horses[i].canMove()) continue;
			
			Board tBoard = horses[i].board;
			int tIndex = horses[i].index;
			
			Location nextLoc = getAfterSpaces(tBoard, tIndex, dices[depth]);
			Board nBoard = nextLoc.board;
			int nIndex = nextLoc.index;
			
			if (!nBoard.isOccupied(nIndex)) {
				tBoard.removeFrom(tIndex);
				nBoard.setAt(nIndex);
				horses[i].set(nBoard, nIndex);
				dfs(depth + 1, ans + nBoard.getScoreAt(nIndex));
				nBoard.removeFrom(nIndex);
				tBoard.setAt(tIndex);
				horses[i].set(tBoard, tIndex);
			}
		}
	}
	
	
	static Location getAfterSpaces(Board b, int i, int s) {
		if (b.name.equals("start")) {
			if (i == 5) {
				return getAfterSpaces(westBoard, 0, s-1);
			}
			else if (i == 10) {
				return getAfterSpaces(southBoard, 0, s-1);
			}
			else if (i == 15) {
				return getAfterSpaces(eastBoard, 0, s-1);
			}
		}
		
		if (i + s > b.length - 1) {
			int canMoveSpace = b.length - 1 - i;
			if (b.name.equals("start")){
				return new Location(b, START_LEN - 1);
			}
			else if (b.name.equals("north")) {
				return getAfterSpaces(startBoard, START_LEN - 2,  s - canMoveSpace - 1);
			}
			else {
				return getAfterSpaces(northBoard, 0, s - canMoveSpace - 1);
			}
		}
		else {
			return new Location(b, i + s);
		}
	}
}

class Board {
    static final int START_LEN = 22;
	String name;
	int length;
	int start;
	int d;
	boolean occupied[];
	
	public Board(String name, int length, int start, int d) {
		this.name = name;
		this.length = length;
		this.start = start;
		this.d = d;
		this.occupied = new boolean[length];
	}
	
    public boolean isArrival(int index, String name){
        return index == START_LEN-1 && name.equals("start");
    }
    
	public int getScoreAt(int index) {
        if (isArrival(index, this.name)) {
			return 0;
		}
		return start + d * index;
	}
	
	public boolean isOccupied(int index) {
		if (isArrival(index, this.name)) {
			return false;
		}
		return occupied[index];
	}
	
	public void removeFrom(int index) {
		occupied[index] = false;
	}
	
	public void setAt(int index) {
		occupied[index] = true;
	}
}

class Location{
    static final int START_LEN = 22;
	Board board;
	int index;
	
	public Location(Board board, int index){
		this.board = board;
		this.index = index;
	}
	
	public boolean canMove() {
		//도착 칸이면 움직일 수 없음
		if (this.index == START_LEN-1 && this.board.name.equals("start"))
			return false;
		return true;
	}

	public void set(Board board, int index){
		this.board = board;
		this.index = index;
	}
	
}
