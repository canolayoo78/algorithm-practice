import sys

input = sys.stdin.readline
write = sys.stdout.write
INF = sys.maxsize


def solution():
    N = int(input())
    postfix = input().strip()
    operand = [int(input()) for _ in range(N)]
    stack = []
    for x in postfix:
        if x == "+":
            b = stack.pop()
            a = stack.pop()
            stack.append(a + b)
        elif x == "-":
            b = stack.pop()
            a = stack.pop()
            stack.append(a - b)
        elif x == "*":
            b = stack.pop()
            a = stack.pop()
            stack.append(a * b)
        elif x == "/":
            b = stack.pop()
            a = stack.pop()
            stack.append(a / b)
        else:
            stack.append(operand[ord(x) - ord("A")])

    print(f"{stack.pop():.2f}")


if __name__ == "__main__":
    solution()
