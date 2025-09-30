import sys 

input = sys.stdin.readline 
write = sys.stdout.write 

def solution():
    str1 = input().strip()
    str2 = input().strip()
    
    ans = 0
    prev = [0] * (len(str2) + 1)
    for i in range(1, len(str1) + 1): 
        cur = [0] * (len(str2) + 1)
        for j in range(1, len(str2) + 1):
            if str1[i - 1] == str2[j - 1]:
                cur[j] = prev[j - 1] + 1
        ans = max(ans, max(cur))
        prev = cur.copy()
    write(str(ans))
    
if __name__ == "__main__":
    solution()
