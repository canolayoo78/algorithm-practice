import sys

input = sys.stdin.readline


def solution():
    N = int(input())
    ans = 1
    one = 1
    two = 1
    sum = 1
    while two != N:
        if sum == N:
            ans += 1
            two += 1
            sum += two
        elif sum > N:
            sum -= one
            one += 1
        else:
            two += 1
            sum += two

    return ans


if __name__ == "__main__":
    print(solution())
