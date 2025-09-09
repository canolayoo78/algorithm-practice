import sys 
from collections import deque 

input = sys.stdin.readline 
write = sys.stdout.write 

def solution(): 
    N, M = map(int, input().split()) 
    board = [list(input().strip()) for _ in range(N)] 
    dx = [0, 1, 0, -1] 
    dy = [1, 0, -1, 0] 
    rx, ry, bx, by = 0, 0, 0, 0
    hole = (0, 0)
    for i in range(N): 
        for j in range(M): 
            if board[i][j] == "R":
                rx, ry = i, j
                board[i][j] = "."
            elif board[i][j] == "B": 
                bx, by = i, j
                board[i][j] = "."
            elif board[i][j] == "O":
                hole = (i, j)
         
    def roll(x, y, dx, dy):
        moved = 0
        while True:
            if board[x + dx][y + dy] == "#":
                break
            x += dx
            y += dy
            moved += 1
            if board[x][y] == "O":
                return x, y, moved, True
        return x, y, moved, False
    
    q = deque([(rx, ry, bx, by, 0)])
    visited = set()
    visited.add((rx, ry, bx, by))
    while q:
        rx, ry, bx, by, depth = q.popleft()
        for i in range(4):
            nrx, nry, r_moved, r_fell = roll(rx, ry, dx[i], dy[i])
            nbx, nby, b_moved, b_fell = roll(bx, by, dx[i], dy[i])
            if depth >= 10:
                continue
            if b_fell:
                continue
            elif r_fell:
                return depth + 1
            if nrx == nbx and nry == nby:
                if r_moved > b_moved:
                    nrx -= dx[i]
                    nry -= dy[i]
                else:
                    nbx -= dx[i]
                    nby -= dy[i]
            if (nrx, nry, nbx, nby) not in visited:
                q.append((nrx, nry, nbx, nby, depth+1))
                visited.add((nrx, nry, nbx, nby))
    return -1

if __name__ == "__main__":
    write(str(solution()))
