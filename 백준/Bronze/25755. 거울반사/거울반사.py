import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    def reverse(num):
        if num == 2:
            return 5
        elif num == 5:
            return 2
        elif num == 1 or num == 8:
            return num
        else:
            return "?"

    direction, N = input().split()
    N = int(N)
    array = []
    for _ in range(N):
        d = list(map(int, input().split()))
        array.append(d)

    if direction in ["U", "D"]:
        for i in range(N - 1, -1, -1):
            for j in range(N):
                print(reverse(array[i][j]), end=" ")
            print()

    else:
        for i in range(N):
            for j in range(N - 1, -1, -1):
                print(reverse(array[i][j]), end=" ")
            print()


if __name__ == "__main__":
    solution()
