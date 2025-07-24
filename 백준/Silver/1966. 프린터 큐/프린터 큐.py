import sys
from collections import deque

input = sys.stdin.readline
INF = sys.maxsize


def solution():
    T = int(input())
    while T > 0:
        N, M = map(int, input().split())
        documents = list(map(int, input().split()))
        importance = [0] * (10)
        out_stream = deque()

        for i in range(N):
            out_stream.append((i, documents[i]))
            importance[documents[i]] += 1

        order = 1
        while out_stream:
            now_index, now_importance = out_stream.popleft()
            flag = True
            for i in range(9, now_importance, -1):
                if importance[i] != 0:
                    flag = False
                    break
            if flag:
                if now_index == M:
                    print(order)
                    break
                else:
                    order += 1
                    importance[now_importance] -= 1
            else:
                out_stream.append((now_index, now_importance))

        T -= 1


if __name__ == "__main__":
    solution()
