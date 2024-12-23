sizeY, sizeX = map(int, input().split())


board = [ input() for _ in range(sizeY) ]



infinity = float('inf')

def solution(board):
    dpB = [[0 for _ in range(sizeX+1)] for _ in range(sizeY+1)]
    dpW = [[0 for _ in range(sizeX+1)] for _ in range(sizeY+1)]
    



    for y in range(1,sizeY+1):
        for x in range(1,sizeX+1):
            bY, bX = y-1, x-1
            cell = board[bY][bX]
            target = 'B' if (x+y)%2==0 else 'W'
            dpB[y][x] = dpB[y-1][x] + dpB[y][x-1] - dpB[y-1][x-1] + ( cell == target)
            dpW[y][x] = dpW[y-1][x] + dpW[y][x-1] - dpW[y-1][x-1] + (cell != target)


    minValue = infinity
    for y in range(8, sizeY+1):
        for x in range(8, sizeX+1):
            minValue = min(minValue, dpB[y][x] - dpB[y][x-8] - dpB[y-8][x] + dpB[y-8][x-8])
            minValue = min(minValue, dpW[y][x] - dpW[y][x-8] - dpW[y-8][x] + dpW[y-8][x-8])
            


    return minValue

print(solution(board))