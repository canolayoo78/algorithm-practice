import sys 
from collections import deque 

input = sys.stdin.readline 

def solution(): 
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]
    directions = ["R", "L", "U", "D"]
    
    def compress_line(line):
        squeezed_line = [x for x in line if x != 0]
        return squeezed_line + [0] * (N - len(squeezed_line))
    
    def merge_line(line):
        line = compress_line(line)
        merged_line = []
        i = 0
        while i < N:
            if i + 1 < N and line[i] != 0 and line[i] == line[i+1]: 
                merged_line.append(line[i] * 2)
                i += 2
            else:
                merged_line.append(line[i])
                i += 1
        return merged_line + [0] * (N - len(merged_line))
    
    def push_left(board):
        return [merge_line(row) for row in board]
    
    def transpose(board):
        return [list(row) for row in zip(*board)]

    def push(board, direction):
        if direction == "L":
            return push_left(board)
        
        elif direction == "R":
            reversed = [row[::-1] for row in board]
            merged = push_left(reversed)
            return [row[::-1] for row in merged]
        
        elif direction == "U":
            t = transpose(board)
            merged = push_left(t)
            return transpose(merged)
        
        else:
            t = transpose(board)
            reversed = [row[::-1] for row in t]
            merged = push_left(reversed)
            reversed_back = [row[::-1] for row in merged]
            return transpose(reversed_back)
    
    q = deque([(board,0)])   
    ans = max(map(max, board))
    
    while q:
        board, moved = q.popleft()
        if moved >= 5:
            continue
        for direction in directions:
            moved_board = push(board, direction)
            max_board = max(map(max,moved_board))
            q.append((moved_board, moved + 1))
            if max_board > ans:
                ans = max_board
    print(ans)            
            
            
if __name__ == "__main__":
    solution()
