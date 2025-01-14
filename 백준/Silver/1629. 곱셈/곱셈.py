import sys

input = sys.stdin.readline
A, B, C = map(int, input().split())


def pow(a, b):
    if b == 1:
        return a % C

    else:
        h = pow(a, b // 2)

        if b % 2 == 0:
            return (h * h) % C

        else:
            return (h * h * a) % C


if __name__ == "__main__":
    print(pow(A, B))
