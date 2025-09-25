import sys 

input = sys.stdin.readline 
write = sys.stdout.write 
INF = sys.maxsize


def solution():
    N = int(input())
    cost = [list(map(int, input().split())) for _ in range(N)] 
 
    def color_with(color):
        cost_color = [row[:] for row in cost] 
        cost_color[0][(color + 1) % 3] = INF
        cost_color[0][(color + 2) % 3] = INF
        
        for i in range(1, N):
            cost_color[i][0] = min(cost_color[i - 1][1], cost_color[i - 1][2]) + cost_color[i][0]
            cost_color[i][1] = min(cost_color[i - 1][0], cost_color[i - 1][2]) + cost_color[i][1]
            cost_color[i][2] = min(cost_color[i - 1][0], cost_color[i - 1][1]) + cost_color[i][2]
        
        cost_color[N-1][color] = INF
        return min(cost_color[N-1])
        
    red_min = color_with(0)
    green_min = color_with(1)
    blue_min = color_with(2)
    
    print(min(red_min, green_min, blue_min))
    

if __name__ == "__main__":
    solution()
