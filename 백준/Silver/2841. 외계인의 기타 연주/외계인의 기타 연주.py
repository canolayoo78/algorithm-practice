import heapq
import sys

input = sys.stdin.readline
write = sys.stdout.write
INF = sys.maxsize


def solution():
    N, P = map(int, input().split())
    pushes = {}

    ans = 0
    for _ in range(N):
        line, fret = map(int, input().split())
        if line in pushes:
            if pushes[line][0] > -fret:
                heapq.heappush(pushes[line], -fret)
                ans += 1
            else:
                while pushes[line] and pushes[line][0] < -fret:
                    heapq.heappop(pushes[line])
                    ans += 1
                if pushes[line] and pushes[line][0] != -fret or not pushes[line]:
                    heapq.heappush(pushes[line], -fret)
                    ans += 1
        else:
            pushes[line] = [-fret]
            heapq.heapify(pushes[line])
            ans += 1

    print(ans)


if __name__ == "__main__":
    solution()
