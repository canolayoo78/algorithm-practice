import sys

input = sys.stdin.readline

def solution():
    A, B, C, X, Y = map(int, input().split())

    ans = float("inf")
    for half in range(0, 2 * max(X, Y) + 1, 2):
        half_cnt = half // 2
        seasoned_chicken = max(0, X - half_cnt)
        fried_chicken = max(0, Y - half_cnt)
        total = seasoned_chicken * A + fried_chicken * B + half_cnt * 2 * C
        ans = min(ans, total)

    print(ans)


if __name__ == "__main__":
    solution()
