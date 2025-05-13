import sys

input = sys.stdin.readline
print = sys.stdout.write


def solution():
    N, M = map(int, input().split())
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

    for _ in range(M):
        func, a, b = map(int, input().split())
        if func == 0:
            union(a, b)
        else:
            if find(a) == find(b):
                print("yes\n")
            else:
                print("no\n")


if __name__ == "__main__":
    solution()
