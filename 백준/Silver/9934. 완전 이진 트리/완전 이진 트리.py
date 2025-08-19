import sys

input = sys.stdin.readline


def solution():
    K = int(input())
    visited_buildings = list(map(int, input().split()))
    result = [[] for _ in range(K)]

    def find(start, end, level):
        if start > end:
            return None
        mid = (start + end) // 2
        result[level].append(visited_buildings[mid])
        find(start, mid - 1, level + 1)
        find(mid + 1, end, level + 1)

    find(0, len(visited_buildings) - 1, 0)
    for r in result:
        print(*r)


if __name__ == "__main__":
    solution()
