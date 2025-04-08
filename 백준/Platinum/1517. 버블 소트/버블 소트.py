import sys

input = sys.stdin.readline

answer = 0
N = int(input())
tmp = [0] * N
numbers = list(map(int, input().split()))

def merge_sort(arr):
    def sort(left, right):
        if right - left < 2:
            return
        mid = (left + right) // 2
        sort(left, mid)
        sort(mid, right)
        merge(left, mid, right)

    def merge(left, mid, right):
        global answer, tmp
        for i in range(left, right):
            tmp[i] = arr[i]
        k, left_index, right_index = left, left, mid
        while left_index < mid and right_index < right:
            if tmp[left_index] <= tmp[right_index]:
                arr[k] = tmp[left_index]
                left_index += 1
                k += 1
            else:
                arr[k] = tmp[right_index]
                right_index += 1
                k += 1
                answer += mid - left_index

        while left_index < mid:
            arr[k] = tmp[left_index]
            left_index += 1
            k += 1

        while right_index < right:
            arr[k] = tmp[right_index]
            right_index += 1
            k += 1


    sort(0, len(arr))


if __name__ == "__main__":
    merge_sort(numbers)
    print(answer)
