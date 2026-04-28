import sys 

input = sys.stdin.readline 
write = sys.stdout.write 
def solution(): 
    N = int(input())
    nums = list(map(int, input().split()))

    sum_of_nums = sum(nums)
    sum_of_num_square = sum(x * x for x in nums)
    ans = (sum_of_nums * sum_of_nums - sum_of_num_square) // 2
    print(ans)
        

if __name__ == "__main__":
    solution()
