import sys

input = sys.stdin.readline


def solution():
    N = int(input())
    string = input().strip()

    count = 1

    for i in range(N - 1):
        if abs(ord(string[i + 1]) - ord(string[i])) == 1:
            count += 1
            if count >= 5:
                return "YES"
        else:
            count = 1

    return "NO"


if __name__ == "__main__":
    print(solution())
