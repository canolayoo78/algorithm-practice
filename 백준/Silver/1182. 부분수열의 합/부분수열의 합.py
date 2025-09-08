import sys

input = sys.stdin.readline
write = sys.stdout.write

def solution(): 
    n, s = map(int,input().split())
    numbers = list(map(int, input().split()))
    ans = 0

    def dfs(index, cur_sum):
        nonlocal ans
        if index == n:
            if cur_sum == s:
                ans += 1
            return
        dfs(index + 1, cur_sum + numbers[index])  
        dfs(index + 1, cur_sum)     

    dfs(0, 0)
    write(str(ans) if s else str(ans - 1))

if __name__ == "__main__":
    solution()
