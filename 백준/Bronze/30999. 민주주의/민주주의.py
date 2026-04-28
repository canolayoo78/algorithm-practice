import sys


input = sys.stdin.readline



def solution():

    N, M = map(int, input().split())

    ans = 0

    for _ in range(N):
        string = input().strip()
        if string.count("O") > M / 2:
            ans += 1

    print(ans)


solution()

 