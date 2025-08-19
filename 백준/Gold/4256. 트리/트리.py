import sys
from collections import deque

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    length = int(input())
    preorder = list(map(int, input().split()))
    inorder = list(map(int, input().split()))
    result = []

    def make_tree(start, end, root):
        # print("start:", start, "end:", end, "root:", root)
        # print("list to sort:", inorder[start : end + 1])
        # print("root_num:", preorder[root])

        if start > end:
            return None
        for i in range(start, end + 1):
            if preorder[root] == inorder[i]:
                break
        if start < i:
            make_tree(start, i - 1, root + 1)
        if i + 1 <= end:
            make_tree(i + 1, end, root + i - start + 1)
        result.append(preorder[root])

    make_tree(0, length - 1, 0)
    print(*result)


if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        solution()
