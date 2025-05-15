import sys

input = sys.stdin.readline
# print = sys.stdout.write


def solution():

    N = int(input())
    _ = int(input())
    set_list = [i for i in range(N + 1)]

    def find(n):
        if set_list[n] == n:
            return n
        else:
            set_list[n] = find(set_list[n])
            return set_list[n]

    def union(a, b):
        a_rep = find(a)
        b_rep = find(b)

        if a_rep != b_rep:
            set_list[b_rep] = a_rep

    for i in range(N):
        linked = list(map(int, input().split()))
        for index, link in enumerate(linked):
            if link:
                union(i + 1, index + 1)

    answer = "YES"
    rep = 0
    paths = list(map(int, input().split()))

    for path in paths:
        if rep == 0:
            rep = find(path)
        elif rep != find(path):
            answer = "NO"
            break

    print(answer)


if __name__ == "__main__":
    solution()
