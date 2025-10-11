import sys 

input = sys.stdin.readline 

def solution():
    n= int(input())
    cross_sum = 0
    
    x, y = map(int, input().split())
    px, py = x, y
    for _ in range(n-1):
        nx, ny = map(int, input().split())
        cross_sum += px * ny - nx * py
        px, py = nx, ny
    cross_sum += px * y - x * py
    
    print(f"{abs(cross_sum) / 2:.1f}")

if __name__ == "__main__":
    solution()
