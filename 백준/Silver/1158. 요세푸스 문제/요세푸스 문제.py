import sys

input = sys.stdin.readline


def find_josephus_permutation(N, K):
    arr = [i for i in range(1, N + 1)]
    josephus_permutation = []
    delete_index = 0

    for _ in range(N):
        delete_index += K - 1
        if delete_index >= len(arr):
            delete_index %= len(arr)
        josephus_permutation.append(arr.pop(delete_index))

    return str(josephus_permutation).replace("[", "<").replace("]", ">")


N, K = map(int, input().split())
print(find_josephus_permutation(N, K))
