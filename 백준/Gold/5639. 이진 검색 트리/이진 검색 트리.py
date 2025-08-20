import sys

write = sys.stdout.write
read = sys.stdin.buffer.read
sys.setrecursionlimit(10**6)

def solution():
    preorder = list(map(int, read().split()))
    result = []

    def find(start, end):
        if start > end:
            return
        split = end + 1
        for i in range(start + 1, end + 1):
            if preorder[i] > preorder[start]:
                split = i
                break
        if start + 1 <= split - 1:
            find(start + 1, split - 1)
        if split <= end:
            find(split, end)
        result.append(preorder[start])

    find(0, len(preorder) - 1)
    write("\n".join(list(map(str, result))))


if __name__ == "__main__":
    solution()
