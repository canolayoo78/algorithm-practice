import sys

input = sys.stdin.readline
write = sys.stdout.write
INF = sys.maxsize


def solution():
    infix = input().strip()
    stack = []
    for x in infix:
        if x in ("+", "-"):
            while stack and stack[-1] != "(":
                write(stack.pop())
            stack.append(x)

        elif x in ("*", "/"):
            while stack and stack[-1] in ("*", "/"):
                write(stack.pop())
            stack.append(x)

        elif x == "(":
            stack.append(x)

        elif x == ")":
            while stack[-1] != "(":
                write(stack.pop())
            stack.pop()

        else:
            write(x)

    while stack:
        write(stack.pop())


if __name__ == "__main__":
    solution()
