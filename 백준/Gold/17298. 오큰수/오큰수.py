import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    N = int(input())
    numbers = list(map(int, input().split()))
    nge = [-1] * N
    stack = [0]

    for i in range(1, N):
        while stack and numbers[stack[-1]] < numbers[i]:
            nge[stack.pop()] = numbers[i]
        stack.append(i)

    write(" ".join(str(n) for n in nge))


if __name__ == "__main__":
    solution()
