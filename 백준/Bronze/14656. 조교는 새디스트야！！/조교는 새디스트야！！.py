import sys

input = sys.stdin.readline

def solution():
    N = int(input())
    students = list(map(int, input().split()))
    ans = 0
    for i in range(N):
        if i + 1 != students[i]:
            ans += 1
    print(ans)


if __name__ == "__main__":
    solution()
