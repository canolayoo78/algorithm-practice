import sys 


input = sys.stdin.readline 
write = sys.stdout.write 
INF = sys.maxsize


def solution():
    N, M = map(int, input().split())
    space = [list(map(int, input().split())) for _ in range(N)]
    space = [[row[:] for row in space] for _ in range(3)]
    
    for i in range(1, N):
        for j in range(0, M):
            if 1 <= j:
                space[0][i][j] = min(space[1][i - 1][j - 1] , space[2][i - 1][j - 1]) + space[0][i][j]
            else:
                space[0][i][j] = INF
            space[1][i][j] = min(space[0][i - 1][j] , space[2][i - 1][j]) + space[1][i][j]
            if j < M -1:
                space[2][i][j] = min(space[0][i - 1][j + 1] , space[1][i - 1][j + 1]) + space[2][i][j]
            else:
                space[2][i][j] = INF

    print(min(min(space[0][N-1]) , min(space[1][N-1]), min(space[2][N-1])))
    

if __name__ == "__main__":
    solution()
