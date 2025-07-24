import sys
from collections import deque

input = sys.stdin.readline
INF = sys.maxsize


def solution():
    T = int(input())
    while T > 0:
        N, M = map(int, input().split())
        documents = list(map(int, input().split()))
        out_stream = deque()

        for i in range(N):
            out_stream.append((i, documents[i]))

        importance = deque(sorted(documents, reverse=True))
        order = 1
        while out_stream:
            now_index, now_importance = out_stream.popleft()

            if now_importance == importance[0]:
                if now_index == M:
                    print(order)
                    break
                else:
                    order += 1
                    importance.popleft()

            else:
                out_stream.append((now_index, now_importance))

        T -= 1


if __name__ == "__main__":
    solution()
