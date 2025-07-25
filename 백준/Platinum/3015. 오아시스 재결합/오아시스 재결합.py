import sys

input = sys.stdin.readline
write = sys.stdout.write
INF = sys.maxsize


def solution():
    N = int(input())
    heigths = [int(input()) for _ in range(N)]

    stack = []
    ans = 0

    for h in heigths:
        while stack and h > stack[-1][0]:
            top_h, top_cnt = stack.pop()
            ans += top_cnt

        if stack and h == stack[-1][0]:
            ans += stack[-1][1]
            stack[-1] = (stack[-1][0], stack[-1][1] + 1)

            if len(stack) >= 2:
                ans += 1

        else:
            if stack and stack[-1][0]:
                ans += 1
            stack.append((h, 1))

    print(ans)


if __name__ == "__main__":
    solution()
