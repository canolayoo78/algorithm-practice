import sys

sys.setrecursionlimit(10**4)
input = sys.stdin.readline


def solution():
    _, M = map(int, input().split())
    trees = list(map(int, input().split()))

    start, end = 1, max(trees)

    while start <= end:
        mid = (start + end) // 2
        log = 0
        for i in trees:
            if i >= mid:
                log += i - mid

        if log >= M:
            start = mid + 1
        else:
            end = mid - 1
    
    print(end)


if __name__ == "__main__":
    solution()
