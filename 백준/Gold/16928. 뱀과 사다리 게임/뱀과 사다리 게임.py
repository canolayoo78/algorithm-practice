import sys
from collections import deque

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    N, M = map(int, input().split())
    ladders, snakes = {}, {}
    for _ in range(N):
        start, end = map(int, input().split())
        ladders[start] = end
    for _ in range(M):
        start, end = map(int, input().split())
        snakes[start] = end

    def bfs(start, moves):
        visited = [False] * 101
        q = deque([(start, moves)])
        visited[start] = True
        while q:
            loc, moves = q.popleft()
            if loc == 100:
                return moves
            for dist in range(1, 7):
                next = loc + dist
                if 1 <= next <= 100 and not visited[next]:
                    visited[next] = True
                    if next in ladders:
                        q.append((ladders[next], moves + 1))
                    elif next in snakes:
                        q.append((snakes[next], moves + 1))
                    else:
                        q.append((next, moves + 1))

    print(bfs(1, 0))


if __name__ == "__main__":
    solution()
