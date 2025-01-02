import sys

sys.setrecursionlimit(10**4)
input = sys.stdin.readline


def solution():
    N = int(input())
    paper = [list(map(int, input().split())) for _ in range(N)]
    ans_0 = 0
    ans_1 = 0

    def cut(x, y, size):
        nonlocal ans_0, ans_1
        temp = sum(sum(row[y : y + size]) for row in paper[x : x + size])

        if temp == 0:
            ans_0 += 1
        elif temp == size**2:
            ans_1 += 1
        else:
            ns = size // 2
            steps = [(0, 0), (ns, 0), (0, ns), (ns, ns)]
            for tx, ty in steps:
                nx, ny = x + tx, y + ty
                if nx in range(N) and ny in range(N):
                    cut(nx, ny, ns)

    cut(0, 0, N)
    print(f"{ans_0}\n{ans_1}")


if __name__ == "__main__":
    solution()
