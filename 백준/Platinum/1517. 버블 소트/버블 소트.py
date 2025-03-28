import sys

input = sys.stdin.readline
answer = 0


def merge_sort(arr):

    def sort(left, right):
        if right - left < 2:
            return
        mid = (left + right) // 2
        sort(left, mid)
        sort(mid, right)
        merge(left, mid, right)

    def merge(left, mid, right):
        global answer
        sorted_arr = []
        left_index, right_index = left, mid
        while left_index < mid and right_index < right:
            if arr[left_index] <= arr[right_index]:
                sorted_arr.append(arr[left_index])
                left_index += 1
            else:
                sorted_arr.append(arr[right_index])
                answer += mid - left_index
                right_index += 1

        while left_index < mid:
            sorted_arr.append(arr[left_index])
            left_index += 1

        while right_index < right:
            sorted_arr.append(arr[right_index])
            right_index += 1

        for i in range(left, right):
            arr[i] = sorted_arr[i - left]

    return sort(0, len(arr))


if __name__ == "__main__":
    N = int(input())
    numbers = list(map(int, input().split()))
    merge_sort(numbers)
    print(answer)
