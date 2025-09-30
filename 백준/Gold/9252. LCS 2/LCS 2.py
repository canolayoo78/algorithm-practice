import sys 

input = sys.stdin.readline 
write = sys.stdout.write 

def solution():
    str1 = input().strip()
    str2 = input().strip()
    len_str1 = len(str1)
    len_str2 = len(str2)
    
    dp = [[0] * (len_str2 + 1) for _ in range(len_str1 + 1)]
    tracking = [[0] * (len_str2 + 1) for _ in range(len_str1 + 1)]
    
    for i in range(1, len_str1 + 1):
        for j in range(1, len_str2 + 1):
            if str1[i - 1] == str2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
                tracking[i][j] = "D"
            elif dp[i][j - 1] <  dp[i - 1][j]: 
                dp[i][j] = dp[i - 1][j]
                tracking[i][j] = "U"
            else:
                dp[i][j] = dp[i][j - 1]
                tracking[i][j] = "L"
    
    ans = ""
    i, j = len_str1, len_str2
    while 0 < i and 0 < j:
        if tracking[i][j] == "D":
            ans = str1[i-1] + ans
            i -= 1
            j -= 1
        elif tracking[i][j] == "U":
            i -= 1
        else:
            j -= 1
    write(str(dp[-1][-1]))
    write(ans)
    
if __name__ == "__main__":
    solution()
