import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    N, M = map(int, input().split())
    string_list = set()

    for _ in range(N):
        string_list.add(input().strip())

    count = 0
    for _ in range(M):
        q = input().strip()
        if q in string_list:
            count += 1
    print(count)


if __name__ == "__main__":
    solution()
