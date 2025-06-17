import sys

input = sys.stdin.readline
MAX = sys.maxsize


def solution():
    N = int(input())
    dp = [[-1] * (N + 1) for _ in range(N + 1)]
    matrixes = [[0, 0]]
    for i in range(1, N + 1):
        matrixes.append(list(map(int, input().split())))

    def excute(s, e):
        if dp[s][e] != -1:
            return dp[s][e]
        if s == e:
            dp[s][e] = 0
            return dp[s][e]
        if s + 1 == e:
            dp[s][e] = matrixes[s][0] * matrixes[s][1] * matrixes[e][1]
            return dp[s][e]

        result = MAX
        for k in range(s, e):
            result = min(
                result,
                excute(s, k)
                + excute(k + 1, e)
                + matrixes[s][0] * matrixes[k][1] * matrixes[e][1],
            )
        dp[s][e] = result
        return dp[s][e]

    print(excute(1, N))


if __name__ == "__main__":
    solution()
