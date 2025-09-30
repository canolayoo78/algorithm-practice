import sys

input = sys.stdin.readline


def solution():
    str1 = input().strip()
    str2 = input().strip()
    prev = [0] * (len(str2) + 1)
    cur = [0] * (len(str2) + 1)
    
    for i in range(1, len(str1) + 1):
        for j in range(1, len(str2) + 1):
            if str1[i - 1] == str2[j - 1]:
                cur[j] = prev[j - 1] + 1
            else:
                cur[j] = max(prev[j], cur[j - 1])
        prev = cur.copy()
      
    print(cur[-1])


if __name__ == "__main__":
    solution()
