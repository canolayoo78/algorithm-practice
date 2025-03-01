import heapq
import sys

input = sys.stdin.readline
INF = sys.maxsize

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def solution(N):
    rupoor = [[INF] * N for _ in range(N)]
    cave = [list(map(int, input().split())) for _ in range(N)]

    q = []
    heapq.heappush(q, (cave[0][0], 0, 0))
    rupoor[0][0] = cave[0][0]

    while q:
        r, x, y = heapq.heappop(q)
        if x == N - 1 and y == N - 1:
            return rupoor[x][y]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N:
                cost = r + cave[nx][ny]
                if cost < rupoor[nx][ny]:
                    rupoor[nx][ny] = cost
                    heapq.heappush(q, (cost, nx, ny))


if __name__ == "__main__":
    count = 1
    while True:
        N = int(input())
        if N == 0:
            break
        print(f"Problem {count}: {solution(N)}")
        count += 1
