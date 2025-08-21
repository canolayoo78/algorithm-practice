import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


def solution():
    N = int(input())
    graph = [[] for _ in range(N + 1)]
    for _ in range(N - 1):
        s, e, w = map(int, input().split())
        graph[s].append((e, w))
    dp = [0] * (N + 1)
    ans = 0

    def cal_dia(node):
        nonlocal ans
        if dp[node]:
            return dp[node]
        candidates = []
        for cand_node, weight in graph[node]:
            candidates.append(cal_dia(cand_node) + weight)
        if not candidates:
            return dp[node]
        candidates.sort(reverse=True)
        dp[node] = candidates[0]
        ans = max(ans, sum(candidates[:2]))
        return dp[node]

    cal_dia(1)
    print(ans)


if __name__ == "__main__":
    solution()
