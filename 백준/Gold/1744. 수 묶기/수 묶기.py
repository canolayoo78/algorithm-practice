import sys


input = sys.stdin.readline
print = sys.stdout.write


def solution():

    N = int(input())
    negative_nums = []
    positive_nums = []
    ans = 0

    for _ in range(N):
        num = int(input())
        if num > 1:
            positive_nums.append(num)
        elif num <= 0:
            negative_nums.append(num)
        else:
            ans += 1

    def make_bundle(nums):
        nonlocal ans
        for i in range(0, len(nums), 2):
            if i + 1 >= len(nums):
                ans += nums[i]
            else:
                ans += nums[i] * nums[i + 1]

    make_bundle(sorted(negative_nums))
    make_bundle(sorted(positive_nums, reverse=True))
    print(str(ans))


if __name__ == "__main__":
    solution()
