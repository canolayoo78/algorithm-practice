import sys

input = sys.stdin.readline
# print = sys.stdout.write


def solution():
    N = int(input())
    numbers = list(map(int, input().split()))
    numbers.sort()

    answer = 0
    for i in range(N):
        target = numbers[i]
        left, right = 0, N - 1

        while left < right:
            if left == i:
                left += 1
                continue

            if right == i:
                right -= 1
                continue

            if target == numbers[left] + numbers[right]:
                answer += 1
                break

            elif target > numbers[left] + numbers[right]:
                left += 1

            else:
                right -= 1

    print(answer)


if __name__ == "__main__":
    solution()
