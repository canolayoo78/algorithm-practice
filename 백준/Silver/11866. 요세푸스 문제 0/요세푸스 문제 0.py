import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    N, K = map(int, input().split())
    array = list(range(1, N + 1))
    result = []
    index = 0
    while array:
        index += K - 1
        index %= len(array)
        result.append(array.pop(index))
    write("<")
    write(", ".join(str(r) for r in result))
    write(">")


if __name__ == "__main__":
    solution()
