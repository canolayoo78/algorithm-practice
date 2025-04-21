import sys

input = sys.stdin.readline


def solution():
    N, M = map(int, input().split())
    lectures = list(map(int, input().split()))

    left, right = max(lectures), sum(lectures)

    while left <= right:
        mid = (left + right) // 2

        count, temp_sum = 0, 0
        for i in range(N):
            if temp_sum + lectures[i] > mid:
                count += 1
                temp_sum = 0
            temp_sum += lectures[i]

        if temp_sum != 0:
            count += 1

        if count > M:
            left = mid + 1

        else:
            right = mid - 1

    print(left)  # 종료될 때 mid + 1로 탈출하므로 left 그대로 출력력


if __name__ == "__main__":
    solution()
