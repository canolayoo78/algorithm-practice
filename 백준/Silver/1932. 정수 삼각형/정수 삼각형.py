import sys

input = sys.stdin.readline


def solution():
    N = int(input())
    tree = []
    for i in range(N):
        tree.append(list(map(int, input().split())))

    for level in range(1, N + 1):
        now = N - level

        for i in range(len(tree[now]) - 1):
            if tree[now][i] >= tree[now][i + 1]:
                tree[now - 1][i] += tree[now][i]
            else:
                tree[now - 1][i] += tree[now][i + 1]

    print(tree[0][0])


if __name__ == "__main__":
    solution()
