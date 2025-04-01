import sys

input = sys.stdin.readline
print = sys.stdout.write


def solution():
    N = int(input())
    M = int(input())
    materials = list(map(int, input().split()))
    materials.sort()

    one = 0
    two = N - 1
    ans = 0

    while one < two:
        sum = materials[one] + materials[two]
        if sum == M:
            ans += 1
            one += 1
            two -= 1
        elif sum < M:
            one += 1
        else:
            two -= 1

    print(str(ans))


if __name__ == "__main__":
    solution()
