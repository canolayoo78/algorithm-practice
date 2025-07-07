import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    def is_walkable(route):
        used = [False] * N
        for i in range(N - 1):
            if route[i] == route[i + 1]:
                continue

            if route[i] + 1 == route[i + 1]:
                for j in range(L):
                    if i - j < 0 or used[i - j] or route[i - j] != route[i]:
                        return False
                for j in range(L):
                    used[i - j] = True

            elif route[i] - 1 == route[i + 1]:
                for j in range(1, L + 1):
                    if i + j >= N or used[i + j] or route[i + j] != route[i + 1]:
                        return False
                for j in range(1, L + 1):
                    used[i + j] = True

            else:
                return False

        return True

    N, L = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]
    count = 0
    for i in range(N):
        if is_walkable(board[i]):
            count += 1
        if is_walkable([board[j][i] for j in range(N)]):
            count += 1
    print(count)


if __name__ == "__main__":
    solution()
