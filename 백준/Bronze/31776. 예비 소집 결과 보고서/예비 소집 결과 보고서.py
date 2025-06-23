import sys

input = sys.stdin.readline
write = sys.stdout.write
MAX = 121


def solution():
    def solve(times):
        if sum(times) == -3:
            return False

        for i in range(3):
            if times[i] == -1:
                times[i] = MAX

        for i in range(2):
            if times[i] > times[i + 1]:
                return False
        return True

    N = int(input())
    ans = 0
    for _ in range(N):
        times = list(map(int, input().split()))
        if solve(times):
            ans += 1
    print(ans)


if __name__ == "__main__":
    solution()
