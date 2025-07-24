import sys
from collections import deque

input = sys.stdin.readline
INF = sys.maxsize


def solution():
    T = int(input())

    for _ in range(T):
        N, M = map(int, input().split())
        documents = list(map(int, input().split()))
        out_stream = [(i, documents[i]) for i in range(N)]
        documents.sort(reverse=True)

        index = 0
        order = 0

        while True:
            if out_stream[index][1] == documents[order]:
                if out_stream[index][0] == M:
                    print(order + 1)
                    break
                order += 1
            else:
                out_stream.append((out_stream[index]))
            index += 1


if __name__ == "__main__":
    solution()
