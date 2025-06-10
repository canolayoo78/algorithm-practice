import sys

input = sys.stdin.readline

def solution():
    def dfs(n):
        tree[n] = -2
        for i in range(N):
            if tree[i] == n:
                dfs(i)

    N = int(input())
    tree = list(map(int, input().split()))
    delete_node = int(input())
    dfs(delete_node)
    cnt = 0
    for i in range(N):
        if tree[i] != -2 and i not in tree:
            cnt += 1
    print(cnt)


if __name__ == "__main__":
    solution()
